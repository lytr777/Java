(defn getMeth [this meth] (if (contains? this meth) (get this meth) (get ((get this :proto) this) meth)))

(defn evaluate [this argsMap] ((getMeth this :evaluate) argsMap))

(defn toString [this] (getMeth this :toString))

(defn diff [this var] ((get this :diff) var))

(defn Constant [value] {:evaluate (fn [argsMap] value)
                        :toString (str " " value " ")
                        :diff (fn [var] (Constant 0))})

(defn Variable [name] {:evaluate (fn [argsMap] (get argsMap name))
                       :toString (str " " name " ")
                       :diff (fn [var] (if (= var name) (Constant 1) (Constant 0)))})

(defn Negate [arg] {:evaluate (fn [argsMap] (- (evaluate arg argsMap)))
                    :toString (str "(Negate " (toString arg) " )")
                    :diff (fn [var] (Negate (diff arg var)))})

(defn AbstractBin [this] {:evaluate (fn [argsMap] (apply (eval (get this :op)) (map (fn[a] (evaluate a argsMap)) (get this :args))))
                          :toString (str "(" (get this :op) " " (apply str (map toString (get this :args))) ") ")})

(defn Add [& args] {:proto AbstractBin
                    :op '+
                    :args args
                    :diff (fn [var] (apply Add (map (fn [this] (diff this var)) args)))})

(defn Subtract [& args] {:proto AbstractBin
                         :op '-
                         :args args
                         :diff (fn [var] (apply Subtract (map (fn [this] (diff this var)) args)))})
(declare Divide)

(defn Multiply [& args] {:proto AbstractBin
                         :op '*
                         :args args
                         :diff (fn [var] (apply Add (map (fn [this] (Divide (Multiply (apply Multiply args) (diff this var)) this)) args)))})

(defn Divide [& args] {:proto AbstractBin
                       :op '/
                       :args args
                       :diff (fn [var] (Divide
                                         (Subtract
                                           (Multiply (diff (first args) var) (first (next args)))
                                           (Multiply (first args) (diff (first (next args)) var)))
                                         (Multiply (first (next args)) (first (next args)))))})

(declare Cos)

(defn Sin [arg] {:evaluate (fn [argsMap] (Math/sin (evaluate arg argsMap)))
                 :toString (str "(Sin " (toString arg) ") ")
                 :diff (fn [var] (Multiply (diff arg var) (Cos arg)))})

(defn Cos [arg] {:evaluate (fn [argsMap] (Math/cos (evaluate arg argsMap)))
                 :toString (str "(Cos " (toString arg) ") ")
                 :diff (fn [var] (Multiply (Negate (Sin arg)) (diff arg var)))})

(def Operators {'+ Add,
                '- Subtract,
                '* Multiply,
                '/ Divide
                'negate Negate
                'sin Sin
                'cos Cos
                })

(defn parseRecur [tokens]
  (if (number? tokens) (Constant tokens)
    (if (symbol? tokens) (Variable (name tokens))
      (apply (Operators (first tokens)) (map parseRecur (rest tokens))))))

(defn parseObject [expression] (parseRecur (read-string expression)))


(print (toString (diff (Negate (Multiply (Variable "z") (Variable "x") (Variable "z"))) "z")))