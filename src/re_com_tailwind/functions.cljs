(ns re-com-tailwind.functions
  (:require
   [cljs-time.core :as cljs-time]
   [clojure.string :as string]

   [re-com.util :as util]))


(def visualise-flow? false)


;; ------------------------------------------------------------------------------------
;;  Private Helper functions
;; ------------------------------------------------------------------------------------

(defn flex-child-style
  "Determines the value for the 'flex' attribute (which has grow, shrink and basis), based on the :size parameter.
   IMPORTANT: The term 'size' means width of the item in the case of flex-direction 'row' OR height of the item in the case of flex-direction 'column'.
   Flex property explanation:
    - grow    Integer ratio (used with other siblings) to determined how a flex item grows it's size if there is extra space to distribute. 0 for no growing.
    - shrink  Integer ratio (used with other siblings) to determined how a flex item shrinks it's size if space needs to be removed. 0 for no shrinking.
    - basis   Initial size (width, actually) of item before any growing or shrinking. Can be any size value, e.g. 60%, 100px, auto
              Note: auto will cause the initial size to be calculated to take up as much space as possible, in conjunction with it's siblings :flex settings.
   Supported values:
    - initial            '0 1 auto'  - Use item's width/height for dimensions (or content dimensions if w/h not specified). Never grow. Shrink (to min-size) if necessary.
                                       Good for creating boxes with fixed maximum size, but that can shrink to a fixed smaller size (min-width/height) if space becomes tight.
                                       NOTE: When using initial, you should also set a width/height value (depending on flex-direction) to specify it's default size
                                             and an optional min-width/height value to specify the size it can shrink to.
    - auto               '1 1 auto'  - Use item's width/height for dimensions. Grow if necessary. Shrink (to min-size) if necessary.
                                       Good for creating really flexible boxes that will gobble as much available space as they are allowed or shrink as much as they are forced to.
    - none               '0 0 auto'  - Use item's width/height for dimensions (or content dimensions if not specified). Never grow. Never shrink.
                                       Good for creating rigid boxes that stick to their width/height if specified, otherwise their content size.
    - 100px              '0 0 100px' - Non flexible 100px size (in the flex direction) box.
                                       Good for fixed headers/footers and side bars of an exact size.
    - 60%                '60 1 0px'  - Set the item's size (it's width/height depending on flex-direction) to be 60% of the parent container's width/height.
                                       NOTE: If you use this, then all siblings with percentage values must add up to 100%.
    - 60                 '60 1 0px'  - Same as percentage above.
    - grow shrink basis  'grow shrink basis' - If none of the above common values above meet your needs, this gives you precise control.
   If number of words is not 1 or 3, an exception is thrown.
   Reference: http://www.w3.org/TR/css3-flexbox/#flexibility
   Diagram:   http://www.w3.org/TR/css3-flexbox/#flex-container
   Regex101 testing: ^(initial|auto|none)|(\\d+)(px|%|em)|(\\d+)\\w(\\d+)\\w(.*) - remove double backslashes"
  [size]
  ;; TODO: Could make initial/auto/none into keywords???
  (let [size (or size "0 1 auto")
        split-size      (string/split (string/trim size) #"\s+")            ;; Split into words separated by whitespace
        split-count     (count split-size)
        _               (assert (contains? #{1 3} split-count) "Must pass either 1 or 3 words to flex-child-style")
        size-only       (when (= split-count 1) (first split-size))         ;; Contains value when only one word passed (e.g. auto, 60px)
        split-size-only (when size-only (string/split size-only #"(\d+)(.*)")) ;; Split into number + string
        [_ num units]   (when size-only split-size-only)                    ;; grab number and units
        pass-through?   (nil? num)                                          ;; If we can't split, then we'll pass this straight through
        grow-ratio?     (or (= units "%") (= units "") (nil? units))        ;; Determine case for using grow ratio
        grow            (if grow-ratio? num "0")                            ;; Set grow based on percent or integer, otherwise no grow
        shrink          (if grow-ratio? "1" "0")                            ;; If grow set, then set shrink to even shrinkage as well
        basis           (if grow-ratio? "0px" size)                         ;; If grow set, then even growing, otherwise set basis size to the passed in size (e.g. 100px, 5em)
        flex            (if (and size-only (not pass-through?))
                          (str grow " " shrink " " basis)
                          size)]
    {:-webkit-flex flex
             :flex flex}))


(defn flex-flow-style
  "A cross-browser helper function to output flex-flow with all it's potential browser prefixes"
  [flex-flow]
  {:-webkit-flex-flow flex-flow
           :flex-flow flex-flow})

(defn justify-style
  "Determines the value for the flex 'justify-content' attribute.
   This parameter determines how children are aligned along the main axis.
   The justify parameter is a keyword.
   Reference: http://www.w3.org/TR/css3-flexbox/#justify-content-property"
  [justify]
  (let [js (case justify
             :start   "flex-start"
             :end     "flex-end"
             :center  "center"
             :between "space-between"
             :around  "space-around"
             "flex-start")]
    {:-webkit-justify-content js
             :justify-content js}))


(defn align-style
  "Determines the value for the flex align type attributes.
   This parameter determines how children are aligned on the cross axis.
   The justify parameter is a keyword.
   Reference: http://www.w3.org/TR/css3-flexbox/#align-items-property"
  [attribute align]
  (let [attribute-wk (->> attribute name (str "-webkit-") keyword)
        as           (case align
                       :start    "flex-start"
                       :end      "flex-end"
                       :center   "center"
                       :baseline "baseline"
                       :stretch  "stretch"
                       "stretch")]
    {attribute-wk as
     attribute    as}))


(defn scroll-style
  "Determines the value for the 'overflow' attribute.
   The scroll parameter is a keyword.
   Because we're translating scroll into overflow, the keyword doesn't appear to match the attribute value"
  [attribute scroll]
  {attribute (case scroll
                  :auto  "auto"
                  :off   "hidden"
                  :on    "scroll"
                  :spill "visible")})

(defn- =date [date1 date2]
  (and
    (= (cljs-time/year date1)  (cljs-time/year date2))
    (= (cljs-time/month date1) (cljs-time/month date2))
    (= (cljs-time/day date1)   (cljs-time/day date2))))

(def list-style
  {:overflow-x     "hidden"
   :overflow-y     "auto"}) ;;TODO this should be handled by scroller later

(def spacing-bordered
  {:padding-top    "0px"
   :padding-bottom "0px"
   :padding-left   "5px"
   :padding-right  "5px"
   :margin-top     "5px"
   :margin-bottom  "5px"})

(def spacing-unbordered
  {:padding-left   "0px"
   :padding-right  "5px"
   :padding-top    "0px"
   :padding-bottom "0px"
   :margin-top     "0px"
   :margin-bottom  "0px"})

(defn calculate-split-flex-style [value is-px?]
  (if is-px?
    (if (pos? value)
      (str "0 0 " value "px") ;; flex for panel-1
      (str "1 1 0px")) ;; flex for panel-2
    (str value " 1 0px")))

(def px (memoize util/px))



