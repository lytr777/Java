(defn evaluate [operator argsMap & args] (reduce operator (map (fn [a] (a argsMap)) args)))

(defn constant [value] (fn [argsMap] value))

(defn variable [name] (fn [argsMap] (get argsMap name)))

(defn add [& args] (fn [argsMap] (apply evaluate + argsMap args)))

(defn subtract [& args] (fn [argsMap] (apply evaluate - argsMap args)))

(defn multiply [& args] (fn [argsMap] (apply evaluate * argsMap args)))

(defn divide [& args] (fn [argsMap] (apply evaluate #(try (/ %1 %2) (catch Exception e (/ 1.0 0))) argsMap args)))

(defn negate [arg] (fn [argsMap] (- (arg argsMap))))

(defn sin [arg] (fn [argsMap] (Math/sin (arg argsMap))))

(defn cos [arg] (fn [argsMap] (Math/cos (arg argsMap))))

(def Operators {'+ add,
                '- subtract,
                '* multiply,
                '/ divide,
                'negate negate,
                'sin sin,
                'cos cos
                })

(defn parseRecur [tokens]
  (if (number? tokens) (constant tokens)
    (if (symbol? tokens) (variable (name tokens))
      (loop [operator (first tokens) operands (rest tokens) vect []]
        (if (nil? (first operands)) (apply (Operators operator) vect)
          (recur operator (rest operands) (conj vect (parseRecur (first operands)))))))
    )
  )

(defn parseFunction [expression] (parseRecur (read-string expression)))