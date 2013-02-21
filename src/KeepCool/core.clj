(ns KeepCool.core)

(def game-state (atom {}))

(defn game-init
  []
  (reset! game-state
          {:players
           {:CarbonMeter {:carbon 100}
            :US {:carbon 20 :blackFac 5 :greenFac 0}
            :EU {:carbon 20 :blackFac 3 :greenFac 1}
            :TC {:carbon 20 :blackFac 2 :greenFac 0}
            :DC {:carbon 20 :blackFac 1 :greenFac 0}
            :FSU {:carbon 20 :blackFac 1 :greenFac 0}
            :OPEC {:carbon 20 :blackFac 1 :greenFac 0}}
           :playerTurn :US}))

(defn get-carbon-meter-level
  []
  (get-in @game-state [:players :CarbonMeter :carbon]))

(defn set-carbon-meter-level
  [new-val]
  (swap! game-state 
         (fn [old-state]
           (assoc-in old-state [:players :CarbonMeter :carbon] new-val))))
