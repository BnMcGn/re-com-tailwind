(ns re-com-tailwind
  (:require
   [re-com-tailwind.functions :refer [flex-child-style flex-flow-style justify-style align-style scroll-style =date calculate-split-flex-style px]]

   [re-com.alert]
   [re-com.box]
   [re-com.buttons]
   [re-com.checkbox]
   [re-com.close-button]
   [re-com.datepicker]
   [re-com.dropdown]
   [re-com.input-text]
   [re-com.typeahead]
   [re-com.input-time]
   [re-com.splits]
   [re-com.modal-panel]
   [re-com.multi-select]
   [re-com.popover]
   [re-com.progress-bar]
   [re-com.radio-button]
   [re-com.selection-list]
   [re-com.slider]
   [re-com.tabs]
   [re-com.tag-dropdown]
   [re-com.text]
   [re-com.throbber]
   [re-com.tour]
   [re-com.v-table]
   [re-com.simple-v-table]))

(def re-com.alert/alert-box-css-spec
  {:main {:class (fn [{:keys [alert-type]}]
                   ["rc-alert" "alert" "fade" "in"
                    (case alert-type
                      :none          nil
                      :info           "alert-success"
                      :warning        "alert-warning"
                      :danger         "alert-danger"
                      nil)])
          :style (fn [{:keys [padding]}]
                   (merge (flex-child-style "none")
                          {:padding padding}))}
   :heading {:class ["rc-alert-heading"]
             :style (fn [{:keys [body]}]
                      {:margin-bottom (if body "10px" "0px")})}
   :h4 {:class ["rc-alert-h4"]
        :style {:margin-bottom "0px"}}
   :close-button {:class ["rc-alert-close-button"]}
   :body {:class ["rc-alert-body"]}})


(def re-com.alert/alert-list-css-spec
  {:wrapper {:class ["rc-alert-list-wrapper"]}
   :main {:class ["rc-alert-list"]}
   :scroller {:class ["rc-alert-list-scroller"]
              :style (fn [{:keys [max-height]}]
                       {:max-height max-height})}
   :v-box {:class ["rc-alert-list-v-box"]}})




(def visualise-flow? false)

(def re-com.box/box-base-css-spec
  {:main {:class ["display-flex"]
          :style (fn [{:keys [size scroll h-scroll v-scroll width height min-width min-height max-width max-height justify align align-self
                              margin padding border l-border r-border t-border b-border radius bk-color child class style attr]}]
           (merge
            (flex-flow-style "inherit")
            (flex-child-style size)
            (when scroll      (scroll-style   :overflow scroll))
            (when h-scroll    (scroll-style   :overflow-x h-scroll))
            (when v-scroll    (scroll-style   :overflow-y v-scroll))
            (when width       {:width         width})
            (when height      {:height        height})
            (when min-width   {:min-width     min-width})
            (when min-height  {:min-height    min-height})
            (when max-width   {:max-width     max-width})
            (when max-height  {:max-height    max-height})
            (when justify     (justify-style  justify))
            (when align       (align-style    :align-items align))
            (when align-self  (align-style    :align-self align-self))
            (when margin      {:margin        margin})       ;; margin and padding: "all" OR "top&bottom right&left" OR "top right bottom left"
            (when padding     {:padding       padding})
            (when border      {:border        border})
            (when l-border    {:border-left   l-border})
            (when r-border    {:border-right  r-border})
            (when t-border    {:border-top    t-border})
            (when b-border    {:border-bottom b-border})
            (when radius      {:border-radius radius})
            (if bk-color
              {:background-color bk-color}
              (if visualise-flow? {:background-color "lightblue"} {}))))}})

(def re-com.box/gap-css-spec
  {:main {:class ["rc-gap"]
          :style (fn [{:keys [size width height]}]
                   (merge
                    (when size   (flex-child-style size))
                    (when width  {:width width})
                    (when height {:height height})
                    (when visualise-flow? {:background-color "chocolate"})))}})


(def re-com.box/line-css-spec
  {:main {:class ["rc-line"]
          :style (fn [{:keys [size color]}]
                   (merge
                    (flex-child-style (str "0 0 " (or size "1px")))
                    {:background-color (or color "lightgray")}))}})

(def re-com.box/h-box-css-spec
  {:main {:class ["rc-h-box" "display-flex"]
          :style (fn [{:keys [size width height min-width min-height max-width max-height justify align align-self margin padding]
                       :or   {size "none" justify :start align :stretch}}]
                   (merge
                    (flex-flow-style "row nowrap")
                    (flex-child-style size)
                    (when width      {:width      width})
                    (when height     {:height     height})
                    (when min-width  {:min-width  min-width})
                    (when min-height {:min-height min-height})
                    (when max-width  {:max-width  max-width})
                    (when max-height {:max-height max-height})
                    (justify-style justify)
                    (align-style :align-items align)
                    (when align-self (align-style :align-self align-self))
                    (when margin     {:margin     margin})       ;; margin and padding: "all" OR "top&bottom right&left" OR "top right bottom left"
                    (when padding    {:padding    padding})
                    (when visualise-flow? {:background-color "gold"})))}})

(def re-com.box/v-box-css-spec
  {:main {:class ["rc-v-box" "display-flex"]
          :style (fn [{:keys [size width height min-width min-height max-width max-height justify align align-self margin padding]
                       :or   {size "none" justify :start align :stretch}}]
                   (merge
                    (flex-flow-style  "column nowrap")
                    (flex-child-style size)
                    (when width       {:width      width})
                    (when height      {:height     height})
                    (when min-width   {:min-width  min-width})
                    (when min-height  {:min-height min-height})
                    (when max-width   {:max-width  max-width})
                    (when max-height  {:max-height max-height})
                    (justify-style    justify)
                    (align-style      :align-items align)
                    (when align-self  (align-style :align-self align-self))
                    (when margin      {:margin     margin})       ;; margin and padding: "all" OR "top&bottom right&left" OR "top right bottom left"
                    (when padding     {:padding    padding})
                    (when visualise-flow? {:background-color "antiquewhite"})))}})

(def re-com.box/box-css-spec
  {:main {:class ["rc-box"]}})

(def re-com.box/scroller-css-spec
  {:main {:class ["rc-scroller"]}})


(def re-com.box/border-css-spec
  {:main {:class ["rc-border"]}})

(def re-com.buttons/button-css-spec
  {:main {:class ["rc-button" "btn"]
          :style (flex-child-style "none") }
   :wrapper {:class ["rc-button-wrapper" "display-inline-flex"]}
   :tooltip {:class ["rc-button-tooltip"]}})

(def re-com.buttons/md-circle-icon-button-css-spec
  {:main {:class
          (fn [{:keys [size emphasise? disabled?]}]
            ["noselect" "rc-md-circle-icon-button"
             (case size
               :smaller "rc-circle-smaller"
               :larger "rc-circle-larger"
               nil)
             (when emphasise? "rc-circle-emphasis")
             (when disabled? "rc-circle-disabled")])
          :style
          (fn [{:keys [disabled?]}]
                (if disabled?
                  {}
                  {:cursor "pointer"}))}
   :wrapper {:class ["display-inline-flex" "rc-md-circle-icon-button-wrapper"]}
   :tooltip {:class ["rc-md-circle-icon-button-tooltip"]}
   :icon {:class
          (fn [{:keys [md-icon-name]}]
            ["zmdi" "zmdi-hc-fw-rc" md-icon-name "rc-md-circle-icon-button-icon"])}
   })

(def re-com.buttons/md-icon-button-css-spec
  {:main {:class
          (fn [{:keys [size emphasise? disabled?]}]
            ["noselect" "rc-md-icon-button"
             (case size
               :smaller "rc-icon-smaller"
               :larger "rc-icon-larger"
               "rc-icon-larger")
             (when emphasise? "rc-icon-emphasis")
             (when disabled? "rc-icon-disabled")])
          :style
          (fn [{:keys [disabled?]}]
                (if disabled?
                  {}
                  {:cursor "pointer"}))}
   :wrapper {:class ["display-inline-flex" "rc-md-icon-button-wrapper"]}
   :tooltip {:class ["rc-md-icon-button-tooltip"]}
   :icon {:class
          (fn [{:keys [md-icon-name]}]
            ["zmdi" "zmdi-hc-fw-rc" md-icon-name "rc-md-icon-button-icon"])}
   })

(def re-com.buttons/info-button-css-spec
  {:main {:class (fn [{:keys [disabled?]}]
                   ["noselect" "rc-info-button" (when disabled? "rc-icon-disabled")])
          :style (fn [{:keys [disabled?]}]
                   (if disabled?
                     {:cursor "pointer"}))}
   :tooltip {:class ["rc-info-button-popover-anchor-wrapper"]}
   :icon {:class ["rc-info-button-icon"]}})

(def re-com.buttons/row-button-css-spec
  {:main {:class (fn [{:keys [disabled? mouse-over-row?]}]
                   ["noselect" "rc-row-button"
                    (when mouse-over-row? "rc-row-mouse-over-row")
                    (when disabled? "rc-row-disabled")])}
   :wrapper {:class ["display-inline-flex" "rc-row-button-wrapper"]}
   :tooltip {:class ["rc-row-button-tooltip"]}
   :icon {:class (fn [{:keys [md-icon-name]}]
                   ["zmdi" "zmdi-hc-fw-rc" md-icon-name "rc-row-button-icon"])}})

(def re-com.buttons/hyperlink-css-spec
  {:main {:class ["noselect" "rc-hyperlink"]
          :style (fn [{:keys [disabled?]}]
                   (merge
                    (flex-child-style "none")
                    (if disabled?
                      {:cursor "default"
                       :pointer-events "none"
                       :color "grey"}
                      {:cursor "pointer"})))}
   :wrapper {:class ["display-inline-flex" "rc-hyperlink-wrapper"]}
   :tooltip {:class ["rc-hyperlink-tooltip"]}
   :container {:class ["rc-hyperlink-container"]}})

(def re-com.buttons/hyperlink-href-css-spec
  {:main {:class ["rc-hyperlink-href" "noselect"]
          :style (fn [{:keys [disabled?]}]
                   (merge
                    (flex-child-style "none")
                    (if disabled?
                      {:cursor "default"
                       :pointer-events "none"
                       :color "grey"}
                      {:cursor "pointer"})))}
   :wrapper {:class ["rc-hyperlink-href-wrapper" "display-inline-flex"]}
   :tooltip {:class ["rc-hyperlink-href-tooltip"]}})


(def re-com.checkbox/checkbox-css-spec
  {:wrapper {:class ["rc-checkbox-wrapper" "noselect"]}
   :main {:class ["rc-checkbox"]
          :style (merge (flex-child-style "none")
                        {:cursor "default"})}
   :label {:class ["rc-checkbox-label"]
           :style (merge (flex-child-style "none")
                         {:padding-left "8px"
                          :cursor "default"})}})


(def re-com.close-button/close-button-css-spec
  {:wrapper {:class ["rc-close-button"]
             :style (fn [{:keys [div-size disabled?]}]
                      (merge
                       {:display "inline-block"
                        :position "relative"
                        :width (px (or div-size 16))
                        :height (px (or div-size 16))}
                       (when disabled? {:pointer-events "none"})))}
   :main {:style (fn [{:keys [disabled?
                              over?
                              font-size
                              div-size
                              top-offset
                              left-offset
                              color
                              hover-color]}]
                   (let [div-size (or div-size 16)
                         font-size (or font-size 16)
                         color (or color "#ccc")
                         hover-color (or hover-color "#999")]
                     {:position  "absolute"
                      :cursor    (when-not disabled? "pointer")
                      :font-size (px font-size)
                      :color     (if over? hover-color color)
                      :top       (px (- (/ (- font-size div-size) 2) top-offset)  :negative)
                      :left      (px (- (/ (- font-size div-size) 2) left-offset) :negative)}))}
   :icon {:class ["rc-close-button-icon" "zmdi" "zmdi-hc-fw-rc" "zmdi-close"]}})



(def re-com.datepicker/datepicker-css-spec
  {:main {:class ["datepicker" "noselect" "rc-datepicker"]
          :style {:font-size "13px"
                  :position "static"}}
   :border {:class ["rc-datepicker-border"]}
   :wrapper {:class ["rc-datepicker-wrapper"]}
   :table {:class ["rc-datepicker-table" "table-condensed"]}
   :header {:class ["rc-datepicker-header"]}
   :nav {:class ["rc-datepicker-nav"]
         :style {:padding "0px"}
         :attr {:col-span "7"}}
   :prev-year {:class (fn [{:keys [enabled?]}]
                        ["rc-datepicker-prev-year"
                         (if enabled? "rc-datepicker-selectable" "rc-datepicker-disabled")])}
   :prev-year-icon {:class ["rc-datepicker-prev-year-icon"]
                    :attr {:height  "24"
                           :viewBox "0 0 24 24"
                           :width   "24"}}
   :prev-month {:class (fn [{:keys [enabled?]}]
                         ["rc-datepicker-prev-month"
                          (if enabled? "rc-datepicker-selectable" "rc-datepicker-disabled")])}
   :prev-month-icon {:class ["rc-datepicker-prev-month-icon"]
                     :attr {:height  "24"
                            :viewBox "0 0 24 24"
                            :width   "24"}}
   :month {:class ["rc-datepicker-month"]}
   :next-month {:class (fn [{:keys [enabled?]}]
                         ["rc-datepicker-next-month"
                          (if enabled? "rc-datepicker-selectable" "rc-datepicker-disabled")])}
   :next-month-icon {:class ["rc-datepicker-next-month-icon"]
                     :attr {:height  "24"
                            :viewBox "0 0 24 24"
                            :width   "24"}}
   :next-year {:class (fn [{:keys [enabled?]}]
                        ["rc-datepicker-next-year"
                         (if enabled? "rc-datepicker-selectable" "rc-datepicker-disabled")])}
   :next-year-icon {:class ["rc-datepicker-next-year-icon"]
                    :attr {:height  "24"
                           :viewBox "0 0 24 24"
                           :width   "24"}}
   :day {:class (fn [{:keys [day]}]
                  ["rc-datepicker-day" (str "rc-datepicker-day-" (string/lower-case (:name day)))])}
   :week {:class ["rc-datepicker-week"]}
   :dates {:class ["rc-datepicker-dates"]}
   :date {:class (fn [{:keys [disabled? unselectable-day? selected today focus-month date]}]
                   (reduce
                    into
                    (list
                     ["rc-datepicker-date"]
                     (cond disabled?                              ["rc-datepicker-disabled"]
                           unselectable-day?                      ["rc-datepicker-unselectable"]
                           (= focus-month (cljs-time/month date)) ["rc-datepicker-selectable"]
                           :else ["rc-datepicker-selectable" "rc-datepicker-out-of-focus"])
                     (cond (and selected (=date selected date))
                           ["rc-datepicker-selected" "start-date" "end-date"]
                           (and today (=date date today) (not disabled?))
                           ["rc-datepicker-today"]
                           :else []))))}})


(ns re-com.dropdown
  (:require
    [goog.string     :as    gstring]
    [goog.string.format]
    [reagent.dom     :as    rdom]))

(def re-com.dropdown/single-dropdown-css-spec
  {:main {:class (fn [{:keys [free-text? drop-showing? free-text-focused?]}]
                   ["rc-dropdown" "chosen-container" "noselect"
                    (if free-text? "chosen-container-multi" "chosen-container-single")
                    (when (or drop-showing? free-text-focused?) "chosen-container-active")
                    (when drop-showing? "chosen-with-drop")])
          :style (fn [{:keys [width]}]
                   (merge (flex-child-style (if width "0 0 auto" "auto"))
                          (align-style :align-self :start)
                          {:width width}))}
   :tooltip {:class ["rc-dropdown-tooltip"]}
   :chosen-drop {:class ["chosen-drop" "rc-dropdown-chosen-drop"]
                 :style (fn [{:keys [drop-above? top-height drop-height]}]
                          (when drop-above?
                            {:transform (gstring/format "translate3d(0px, -%ipx, 0px)"
                                                        (+ top-height drop-height -2))}))}
   :chosen-results {:class ["chosen-results" "rc-dropdown-chosen-results"]
                    :style (fn [{:keys [max-height]}]
                             (when max-height {:max-height max-height}))}
   :choices {:class ["chosen-choices"]}
   :choices-search {:class ["search-field"]}
   :choices-loading {:class ["loading" "rc-dropdown-choices-loading"]}
   :choices-error {:class ["error" "rc-dropdown-choices-error"]}
   :choices-no-results {:class ["no-results" "rc-dropdown-choices-no-results"]}
   :group-heading {:class ["group-result"]}
   :choice-item {:class (fn [{:keys [selected mouse-over?]}]
                           ["active-result" "group-option" (if selected
                                                             "highlighted"
                                                             (when mouse-over? "mouseover"))])}
   :filter-wrapper {:class ["chosen-search"]}
   :filter-input-box {:style (fn [{:keys [visible?]}]
                          (when-not visible? {:position "absolute" ;; When no filter box required, use it but hide it off screen
                                                 :width    "0px"      ;; The rest of these styles make the textbox invisible
                                                 :padding  "0px"
                                              :border   "none"}))}
   :dropdown-top {:class ["chosen-single" "chosen-default"]
                  :style (fn [{:keys [disabled?]}]
                           (when disabled?
                             {:background-color "#eee"}))}
   :free-text-wrapper {:class ["free-text"]
                       :style (fn [{:keys [disabled?]}]
                                (when disabled?
                                  {:background-color "#eee"}))}
   :free-text {:class ["form-control"]
               :style (fn [{:keys [width]}]
                        {:width width})}
   :free-text-b-wrapper {:class ["b-wrapper"]}})



(def re-com.input-text/input-text-css-spec
  {:main {:class ["form-control" "rc-input-text-field"]
          :style (fn [{:keys [height]}]
                   (merge
                    (flex-child-style "none")
                    {:height height
                     :padding-right "12px"}))}
   :inner {:class (fn [{:keys [status status-icon?]}]
                    ["rc-input-text-inner"
                     (case status
                       :success "has-success"
                       :warning "has-warning"
                       :error "has-error"
                       nil)
                     (when (and status status-icon?) "has-feedback")])
           :style (flex-child-style "auto")}
   :wrapper {:class ["rc-input-text"]}
   :popover {:style (merge (flex-child-style "none")
                           (align-style :align-self :center)
                           {:font-size "130%"
                            :margin-left "4px"})}
   :throbber {:class ["smaller"]}
   :tooltip-icon {:class (fn [{:keys [status]}]
                           ["zmdi" "zmdi-hc-fw"
                            (case
                                status
                              :success "zmdi-check-circle"
                              :warning "zmdi-alert-triangle"
                              :error "zmdi-alert-circle zmdi-spinner"
                              :validating "zmdi-hc-spin zmdi-rotate-right zmdi-spinner"
                              nil)
                            "form-control-feedback"])
                  :style {:position "static"
                          :height "auto"
                          :opacity "1"}}
   :tooltip-icon2 {:class (fn [{:keys [status]}]
                            ["zmdi" "zmdi-hc-fw"
                             (case
                                 status
                               :success "zmdi-check-circle"
                               :warning "zmdi-alert-triangle"
                               :error "zmdi-alert-circle zmdi-spinner"
                               :validating "zmdi-hc-spin zmdi-rotate-right zmdi-spinner"
                               nil)
                             "form-control-feedback"])
                   :style {:position "static"
                           :font-size "130%"
                           :margin-left "4px"
                           :height "auto"
                           :opacity "1"}}})


(def re-com.input-time/input-time-css-spec
  {:wrapper {:class ["rc-input-time"]}
   ;; Leaving time-entry class (below) for backwards compatibility only.
   :main {:class ["rc-time-entry" "time-entry"]
          :style (fn [{:keys [width]}]
                   {:width width})}
   :time-icon-container {:class ["rc-time-icon-container" "time-icon"]}
   :time-icon {:class ["rc-time-icon" "zmdi" "zmdi-hc-fw-rc" "zmdi-time"]
               :style {:position "static"
                       :margin "auto"}}})


(def re-com.modal-panel/modal-panel-css-spec
  {:main {:class ["rc-modal-panel" "display-flex"]
          :style {:position "fixed"
                  :left     "0px"
                  :top      "0px"
                  :width    "100%"
                  :height   "100%"
                  :z-index  1020}}
   :backdrop {:class ["rc-modal-panel-backdrop"]
              :style (fn [{:keys [color opacity]}]
                       {:position         "fixed"
                        :width            "100%"
                        :height           "100%"
                        :background-color (or color "black")
                        :opacity          (or opacity 0.6)
                        :z-index          1})}
   :child-container {:class ["rc-modal-panel-child-container"]
                     :style (fn [{:keys [wrap-nicely?]}]
                              (merge
                               {:margin "auto"
                                :z-index 2}
                               (when wrap-nicely?
                                 {:background-color "white"
                                  :padding "16px"
                                  :border-radius "6px"})))}})


(def re-com.multi-select/multi-select-css-spec
  {:main {:class ["rc-multi-select" "noselect" "chosen-container" "chosen-container-single"]
          :style (fn [{:keys [width]}]
                   (merge (box/flex-child-style (if width "0 0 auto" "auto"))
                          (box/align-style :align-self :start)
                          {:overflow "hidden"
                           :width width}))}
   :container {:class ["rc-multi-select-container"]}
   :left {:class ["rc-multi-select-left"]}
   :left-label-container {:class ["rc-multi-select-left-label-container"]}
   :left-label {:class ["rc-multi-select-left-label"]
                :style {:font-size "small"
                        :font-weight "bold"}}
   :left-label-item-count {:class ["rc-multi-select-left-label-item-count"]
                           :style {:font-size "smaller"}}
   :left-list-box {:class ["rc-multi-select-left-list-box"]}
   :filter-text-box {:class ["rc-multi-select-filter-text-box"]
                     :style {:position "relative"}}
   :filter-input-text {:class ["rc-multi-select-filter-input-text"]
                       :style {:padding "3px 4px"}}
   :filter-reset-button {:class ["rc-multi-select-filter-reset-button"]}
   :left-filter-result-count {:class ["rc-multi-select-left-filter-result-count"]
                              :style {:font-size "smaller"}}
   :middle-container {:class ["rc-multi-select-middle-container"]}
   :middle-spacer {:class ["rc-multi-select-middle-spacer"]}
   ;;TODO: cleanup: middle-[top|bottom]-spacer are not used. Should they go away, or should it be middle-spacer that goes?
   :middle-top-spacer {:class ["rc-multi-select-middle-top-spacer"]}
   :middle {:class ["rc-multi-select-middle"]}
   :button {:class ["rc-multi-select-button"]
            :style {:width        "86px"
                    :height       "24px"
                    :padding      "0px 8px 2px 8px"
                    :margin       "8px 6px"
                    :text-align   "left"
                    :font-variant "small-caps"
                    :font-size    11}}
   :button-icon {:class (fn [{:keys [icon]}]
                          ["zmdi" "zmdi-hc-fw-rc" (str "zmdi-" icon)])}
   :button-content {:style {:position "relative" :top "-1px"}}
   :include-all-button {:class ["rc-multi-select-include-all-button"]}
   :include-selected-button {:class ["rc-multi-select-include-selected-button"]}
   :exclude-selected-button {:class ["rc-multi-select-exclude-selected-button"]}
   :exclude-all-button {:class ["rc-multi-select-exclude-all-button"]}
   :middle-bottom-spacer {:class ["rc-multi-select-middle-bottom-spacer"]}
   :right {:class ["rc-multi-select-right"]
           :style {:position "relative"}}
   :warning-message {:class ["rc-multi-select-warning-message"]
                     :style (fn [{:keys [warning-message]}]
                              (when warning-message
                                {:color            "white"
                                 :background-color "green"
                                 :border-radius    "0px"
                                 :opacity            "0"
                                 :position           "absolute"
                                 :right              "0px"
                                 :z-index            1
                                 :height             "25px"
                                 :padding            "3px 6px"
                                 :animation-name     "rc-multi-select-fade-warning-msg"
                                 :animation-duration "5000ms"}))}
   :right-label-container {:class ["rc-multi-select-right-label-container"]}
   :right-label {:class ["rc-multi-select-right-label"]
                 :style {:font-size "small"
                         :font-weight "bold"}}
   :right-label-item-count {:class ["rc-multi-select-right-label-item-count"]
                            :style {:font-size "smaller"}}
   :right-list-box {:class ["rc-multi-select-right-list-box"]}
   :right-filter-result-count {:class ["rc-multi-select-right-filter-result-count"]
                               :style {:font-size "smaller"}}
   :group-heading-item {:class (fn [{:keys [selected? mouse-over?]}]
                           ["group-result" (if selected?
                                             "highlighted"
                                             (when mouse-over? "mouseover"))])
                        :style (fn [{:keys [disabled? selected?]}]
                                 (merge {:padding-left "6px"
                                         :cursor       (when-not disabled? "pointer")
                                         :color        (if selected? "white" "#444")}
                                        (when disabled?
                                          {:pointer-events "none"})))}
   :list-item {:class (fn [{:keys [selected? mouse-over? disabled?]}]
                        ["active-result" "group-option" (if (and selected? (not disabled?))
                                                          "highlighted"
                                                          (when mouse-over? "mouseover"))])
               :style (fn [{:keys [group-selected? disabled?]}]
                        (merge (when group-selected? {:background-color "hsl(208, 56%, 92%)"})
                               (when disabled? {:cursor         "default"
                                                :pointer-events "none"})))}
   ;;TODO: These class names look foreign, need review
   :list-box {:class (fn [{:keys [disabled?]}]
                       [(if disabled? "bm-multi-select-list-disabled" "bm-multi-select-list")])
              :style {:background-color "#fafafa"
                      :border           "1px solid #ccc"
                      :border-radius    "4px"}}
   :list-box-results {:class ["chosen-results"]
                      :style {:max-height "none"}} ;; Override the 240px in the class
   :list-box-no-results {:class ["no-results"]}})


(def re-com.popover/popover-arrow-css-spec
  {:arrow {:class ["popover-arrow" "rc-popover-arrow"]
          :style (fn [{:keys [orientation pop-offset arrow-length arrow-width]}]
                   {:position "absolute"
                    (case orientation ;; Connect arrow to edge of popover
                      :left  :right
                      :right :left
                      :above :bottom
                      :below :top) (px arrow-length :negative)

                    (case orientation ;; Position the arrow at the top/left, center or bottom/right of the popover
                      (:left  :right) :top
                      (:above :below) :left) (if (nil? pop-offset) "50%" (px pop-offset))

                    (case orientation ;; Adjust the arrow position so it's center is attached to the desired position set above
                      (:left  :right) :margin-top
                      (:above :below) :margin-left) (px (/ arrow-width 2) :negative)

                    :width (px (case orientation ;; Arrow is rendered in a rectangle so choose the correct edge length
                                 (:left  :right) arrow-length
                                 (:above :below) arrow-width))

                    :height (px (case orientation ;; Same as :width comment above
                                  (:left  :right) arrow-width
                                  (:above :below) arrow-length))})}
   :arrow-drawing {:style
                   (fn [{:keys [popover-color grey-arrow? popover-border-color no-border?]}]
                     {:fill (if popover-color
                              popover-color
                              (if grey-arrow? "#f7f7f7" "white"))
                      :stroke (or popover-border-color (when-not no-border? "rgba(0, 0, 0, .2)"))
                      :stroke-width "1"})}})


(def re-com.popover/backdrop-css-spec
  {:main {:class ["noselect" "rc-backdrop"]
          :style (fn [{:keys [opacity]}]
                   {:position         "fixed"
                    :left             "0px"
                    :top              "0px"
                    :width            "100%"
                    :height           "100%"
                    :background-color "black"
                    :opacity          (or opacity 0.0)})}})


(def re-com.popover/popover-title-css-spec
  {:main {:class ["popover-title" "rc-popover-title"]
          :style (merge (flex-child-style "inherit")
                        {:font-size "18px"})}
   :container {}
   :close-button {}})


(def re-com.popover/popover-border-css-spec
  {:main {:class ["popover" "fade" "in" "rc-popover-border"]
          :style (fn [{:keys [top left width height background-color border-color tooltip-style?
                              orientation margin-left margin-top ready-to-show?] :as params}]
                   (merge
                    (into {}
                          (for [k [:top :left :width :height :background-color :border-color
                                   :margin-left :margin-top]
                                :let [v (get params k)]
                                :when v]
                            [k v]))
                    (when tooltip-style?
                      {:border-radius "4px"
                       :box-shadow "none"
                       :border "none"})

                    ;; The popover point is zero width, therefore its absolute children will consider this width when deciding their
                    ;; natural size and in particular, how they natually wrap text. The right hand side of the popover is used as a
                    ;; text wrapping point so it will wrap, depending on where the child is positioned. The margin is also taken into
                    ;; consideration for this point so below, we set the margins to negative a lot to prevent
                    ;; this annoying wrapping phenomenon.
                    (case orientation
                      :left {:margin-left "-2000px"}
                      (:right :above :below) {:margin-right "-2000px"})

                    ;; make it visible and turn off Bootstrap max-width and remove Bootstrap padding which adds an internal white border
                    {:display "block"
                     :opacity (if ready-to-show? "1" "0")
                     :max-width "none"
                     :padding "0px"}))}
   :content {:class ["popover-content" "rc-popover-content"]
             :style (fn [{:keys [padding]}]
                      {:padding padding})}})


(def re-com.popover/popover-content-wrapper-css-spec
  {:main {:class ["popover-content-wrapper" "rc-popover-content-wrapper"]
          :style (fn [{:keys [no-clip? left-offset top-offset]}]
                   (merge (flex-child-style "inherit")
                          (when no-clip?
                            {:position "fixed"
                             :left (px left-offset)
                             :top (px top-offset)})))}
   :backdrop {}
   :border {}
   :title {}})


(def re-com.popover/popover-anchor-wrapper-css-spec
  {:main {:class ["rc-popover-anchor-wrapper" "display-inline-flex"]
          :style (flex-child-style "inherit")}
   :point-wrapper {:class ["display-inline-flex" "rc-point-wrapper"]
                   :style (fn [{:keys [flex-flow]}]
                            (merge (flex-child-style "auto")
                                   (flex-flow-style flex-flow)
                                   (align-style :align-items :center)))}
   :point {:class ["rc-popover-point" "display-inline-flex"]
           :style (merge
                   (flex-child-style "auto")
                   {:position "relative"
                    :z-index 4})}})

(def re-com.popover/popover-tooltip-css-spec
  {:main {:class ["rc-popover-tooltip"]}
   :content-wrapper {}
   :v-box {:style (fn [{:keys [status]}]
                    (if (= status :info)
                      {:color "white"
                       :font-size "14px"
                       :padding "4px"}
                      {:color "white"
                       :font-size "12px"
                       :font-weight "bold"
                       :text-align "center"}))}
   :close-button-container {:class ["rc-popover-tooltip-close-button-container"]}
   :close-button {:class ["rc-popover-tooltip-close-button"]}})


(def re-com.progress-bar/progress-bar-css-spec
  {:wrapper {:class ["rc-progress-bar-wrapper"]}
   :main {:class ["rc-progress-bar" "progress"]
          :style (fn [{:keys [width]}]
                   (merge (flex-child-style "none")
                          {:width (or width "100%")}))}
   :portion {:class (fn [{:keys [striped?]}]
                      ["progress-bar" "active" "rc-progress-bar-portion"
                       (when striped? "progress-bar-striped")])
             :style (fn [{:keys [percent]}]
                      {:width (str percent "%")
                       :transition "none"})}}) ;; Default BS transitions cause the progress bar to lag behind


(def re-com.radio-button/radio-button-css-spec
  {:main {:class ["rc-radio-button"]
          :style (merge
                  (flex-child-style "none")
                  {:cursor "default"})}
   :wrapper {:class ["rc-radio-button-wrapper" "noselect"]}
   :label {:class ["rc-radio-button-label"]
           :style (merge (flex-child-style "none")
                         {:padding-left "8px"
                          :cursor "default"})}})



(def list-style
  ;;TODO: These should be in CSS resource
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


(def re-com.selection-list/selection-list-css-spec
  {:main {:class (fn [{:keys [disabled?]}]
                   ["rc-selection-list" (when disabled? "rc-disabled")])}
   :list-group {:class ["rc-selection-list-group" "list-group" "noselect"]
                :style (fn [{:keys [hide-border? width height max-height]}]
                         (merge
                          list-style
                          (if hide-border? spacing-unbordered spacing-bordered)
                          {:width width :height height :max-height max-height}))}
   :list-group-item {:class ["rc-selection-list-group-item" "list-group-item" "compact"]}
   :checkbox {:class ["rc-selection-list-checkbox"]}
   :radio-button {:class ["rc-selection-list-radio-button"]
                  :style (fn [{:keys [disabled?]}]
                           (when disabled? {:pointer-events "none"}))}})


(def re-com.simple-v-table/simple-v-table-css-spec
  {:simple-wrapper {:class ["rc-simple-v-table-wrapper"]
                    :style (fn [{:keys [max-rows padding max-width table-row-line-color]}]
                             {;; :flex setting
                              ;; When max-rows is being used:
                              ;;  - "0 1 auto" allows shrinking within parent but not growing (to prevent vertical spill)
                              ;; Otherwise:
                              ;;  - "100%" used instead of 1 to resolve conflicts when simple-v-table is the anchor of a popover (e.g. the periodic table demo)
                              :flex             (if max-rows "0 1 auto" "100%")
                              :background-color "white"
                              :padding          padding
                              :max-width        max-width
                              :border           (str "1px solid " (or table-row-line-color "#EAEEF1"))
                              :border-radius    "3px"})}
   :simple-column-header {:class ["rc-simple-v-table-column-header" "noselect"]
                          :style {:padding     "4px 0px"
                                  :overflow    "hidden"
                                  :white-space "nowrap"}}
   :simple-column-header-item {:class ["rc-simple-v-table-column-header-item"]
                               :style (fn [{:keys [height align sort-by]}]
                                        {:padding       "0px 12px"
                                         :min-height    "24px"
                                         :height        (px height)
                                         :font-weight   "bold"
                                         :text-align    align
                                         :white-space   "nowrap"
                                         :overflow      "hidden"
                                         :text-overflow "ellipsis"
                                         :cursor (when sort-by "pointer")})}
   :simple-row {:class ["rc-simple-v-table-row"]
                :style (fn [{:keys [row-height
                                    table-row-line-color
                                    on-click-row odd-row?
                                    row-style
                                    row]}]
                         (merge {:padding     "4px 0px"
                                 :overflow    "hidden"
                                 :white-space "nowrap"
                                 :height      (px row-height)
                                 :border-top  (str "1px solid " table-row-line-color)
                                 :cursor      (when on-click-row "pointer")}
                                (when odd-row? {:background-color "#f2f2f2"})
                                (if (fn? row-style)
                                  (row-style row)
                                  row-style)))}
   :simple-row-item {:class ["rc-simple-v-table-row-item"]
                     :style (fn [{:keys [width height align vertical-align cell-style row column]}]
                              (merge {:display        "inline-block"
                                      :padding        "0px 12px"
                                      :width          (px width)
                                      :height         (px height)
                                      :text-align     align
                                      :vertical-align vertical-align
                                      :white-space    "nowrap"
                                      :overflow       "hidden"
                                      :text-overflow  "ellipsis"}
                                     (if (fn? cell-style)
                                       (cell-style row column)
                                       cell-style)))}})

(def re-com.slider/slider-css-spec
  {:main {:class ["rc-slider"]
          :style (fn [{:keys [width disabled?]}]
                   (merge
                    (flex-child-style "none")
                    {;:-webkit-appearance "slider-vertical"   ;; TODO: Make a :orientation (:horizontal/:vertical) option
                                        ;:writing-mode       "bt-lr"             ;; Make IE slider vertical
                     :width  (or width "400px")
                     :cursor (if disabled? "default" "pointer")}))}
   :wrapper {:class ["rc-slider-wrapper"]}})




(defn calculate-split-flex-style [value is-px?]
  (if is-px?
    (if (pos? value)
      (str "0 0 " value "px") ;; flex for panel-1
      (str "1 1 0px")) ;; flex for panel-2
    (str value " 1 0px")))



(def re-com.splits/hv-split-css-spec
  {:main {:class (fn [{:keys [vertical?]}]
                   [(if vertical? "rc-v-split" "rc-h-split") "display-flex"])
          :style (fn [{:keys [size margin width height vertical?]}]
                   (merge (flex-child-style size)
                          (flex-flow-style (str (if vertical? "column" "row") " nowrap"))
                          {:margin margin
                           :width width
                           :height height}))}
   :splitter {:class (fn [{:keys [vertical?]}]
                       ["display-flex" (if vertical? "rc-v-split-splitter" "rc-h-split-splitter")])
              :style (fn [{:keys [vertical? size over?]}]
                       (merge (flex-child-style (str "0 0 " size))
                              {:cursor (if vertical? "row-resize" "col-resize")}
                              (when over? {:background-color "#f8f8f8"})))}
   :handle {:class (fn [{:keys [vertical?]}]
                     [(if vertical? "rc-v-split-handle" "rc-h-split-handle") "display-flex"])
            :style (fn [{:keys [vertical?]}]
                     (let [[width height] (if vertical? ["8px" "20px"] ["20px" "8px"])]
                       (merge
                        (flex-flow-style (str (if vertical? "row" "column") " nowrap"))
                        {:width width :height height :margin "auto"})))}
   :handle-bar-1 {:class (fn [{:keys [vertical?]}]
                           [(if vertical? "rc-v-split-handle-bar-1" "rc-h-split-handle-bar-1")])
                  :style (fn [{:keys [vertical? over?]}]
                           (let [border (str "solid 1px " (if over? "#999" "#ccc"))]
                             (if vertical?
                               {:width "3px" :height "20px" :border-right border}
                               {:width "20px" :height "3px" :border-bottom border})))}
   :handle-bar-2 {:class (fn [{:keys [vertical?]}]
                           [(if vertical? "rc-v-split-handle-bar-2" "rc-h-split-handle-bar-2")])
                  :style (fn [{:keys [vertical? over?]}]
                           (let [border (str "solid 1px " (if over? "#999" "#ccc"))]
                             (if vertical?
                               {:width "3px" :height "20px" :border-right border}
                               {:width "20px" :height "3px" :border-bottom border})))}
   ;; Leaving rc-h-split-top class (below) for backwards compatibility only.
   :left {:class ["rc-h-split-left" "rc-h-split-top" "display-flex"]
          :style (fn [{:keys [flex dragging?]}]
                   (merge (flex-child-style flex)
                          (when dragging? {:pointer-events "none"})))}
   ;; Leaving rc-h-split-bottom class (below) for backwards compatibility only.
   :right {:class ["rc-h-split-right" "rc-h-split-bottom" "display-flex"]
           :style (fn [{:keys [flex dragging?]}]
                    (merge (flex-child-style flex)
                           (when dragging? {:pointer-events "none"})))}
   :top {:class ["rc-v-split-top" "display-flex"]
         :style (fn [{:keys [flex dragging?]}]
                  (merge (flex-child-style flex)
                         (when dragging? {:pointer-events "none"})))}
   :bottom {:class ["rc-v-split-bottom" "display-flex"]
            :style (fn [{:keys [flex dragging?]}]
                     (merge (flex-child-style flex)
                            (when dragging? {:pointer-events "none"})))}})



(def re-com.tabs/horizontal-tabs-css-spec
  {:wrapper {:class ["nav" "nav-tabs" "noselect" "rc-tabs"]
             :style (flex-child-style "none")
             :use-toplevel true}
   :tab {:class (fn [{:keys [selected?]}]
                  ["rc-tab" (when selected? "active")])}
   :anchor {:class ["rc-tab-anchor"]
            :style {:cursor "pointer"}}})


(def re-com.tabs/bar-tabs-css-spec
  {:wrapper {:class (fn [{:keys [vertical?]}]
                      ["noselect" (if vertical? "btn-group-vertical" "btn-group") "rc-tabs"])
             :style (flex-child-style "none")}
   :tooltip {:class ["rc-tabs-tooltip"]}
   :button {:class (fn [{:keys [selected?]}]
                     ["btn" "btn-default" (when selected? "active") "rc-tabs-btn"])}})

(def re-com.tabs/pill-tabs-css-spec
  {:wrapper {:class (fn [{:keys [vertical?]}]
                      ["rc-tabs" "noselect" "nav" "nav-pills" (when vertical? "nav-stacked")])
             :style (flex-child-style "none")}
   :tab {:class (fn [{:keys [selected?]}]
                  ["rc-tabs-pill" (when selected? "active")])}
   :anchor {:class ["rc-tabs-anchor"]
            :style {:cursor "pointer"}}})



(def re-com.tag-dropdown/tag-dropdown-css-spec
  {:main {:class ["rc-tag-dropdown"]
          :style (fn [{:keys [disabled?]}]
                   {:background-color (if disabled? "#EEE" "white")
                    :color            "#BBB"
                    :border           "1px solid lightgrey"
                    :border-radius    "2px"
                    :overflow         "hidden"
                    :cursor           (if disabled? "default" "pointer")})}
   :tags {:class ["rc-tag-dropdown-tags"]
          :style {:overflow "hidden"}}

   :tag {:class ["rc-tag-dropdown-tag"]}
   :tag-box {:class ["noselect" "rc-text-tag"]
             :style (fn [{:keys [background-color disabled? placeholder?]}]
                      {:color "white"
                       :background-color background-color
                       :cursor (if disabled? "default" "pointer")
                       :font-size "12px"
                       :border (when placeholder? "1px dashed #828282")
                       :border-radius "3px"})}
   :tag-label {:style (fn [{:keys [placeholder? clickable?]}]
                        (if placeholder?
                          {:color "hsl(194, 61%, 85%)"}
                          (when clickable? {:cursor "pointer"})))}
   :tag-close-spacer {:style {:margin-left "4px"
                              :margin-right "3px"}}
   :tag-description {:style {:color "#586069"}}

   :close-button-wrapper {:style {:margin-left "5px"}}
   :selection-list {:class ["rc-tag-dropdown-selection-list"]}
   :popover-anchor-wrapper {:class ["rc-tag-dropdown-popover-anchor-wrapper"]}})


(def re-com.text/label-css-spec
  {:main {:class ["rc-label"]
          :style (flex-child-style "none")}
   :wrapper {:class ["rc-label-wrapper" "display-inline-flex"]}})


(def re-com.text/title-css-spec
  {:wrapper {:class (fn [{:keys [level]}]
                      ["rc-title-wrapper" (when level (name level))])}
   :main {:class (fn [{:keys [level]}]
                   ["rc-title" "display-flex" (when level (name level))])
          :style (fn [{:keys [margin-top underline? margin-bottom]}]
                   (merge
                    (flex-child-style "none")
                    {:margin-top (or margin-top "0.6em")
                     :margin-bottom (when-not underline? (or margin-bottom "0.3em"))
                     ;; so that the margins are correct
                     :line-height 1}))}
   :underline {:class ["rc-title-underline"]
               :style (fn [{:keys [margin-bottom]}]
                        {:margin-bottom (or margin-bottom "0.3em")})}})


(def re-com.text/p-css-spec
  {:main {:class ["rc-p"]
          :style {:flex          "none"
                  :width         "450px"
                  :min-width     "450px"
                  :margin-bottom "0.7em"}}})

(def re-com.throbber/throbber-css-spec
  {:wrapper {:class ["rc-throbber-wrapper"]}
   :main {:class (fn [{:keys [size]}]
                   ["loader" "rc-throbber"
                    (case size
                      :regular nil
                      :smaller "smaller"
                      :small "small"
                      :large "large"
                      nil)])}
   :segment {:class ["rc-throbber-segment"]
             :style (fn [{:keys [color]}]
                      (when color {:background-color color}))}})

(def re-com.tour/tour-css-spec
  {:line {:style (merge (flex-child-style "none")
                        {:margin "10px 0px 10px"})}
   :prev-button {:class ["btn-default" "rc-tour-btn-previous"]
                 :style {:margin-right "15px"}}
   :next-button {:class (fn [{:keys [last-button?]}]
                          ["btn-default" (if last-button? "rc-tour-btn-finish" "rc-tour-btn-next")])}})

(def re-com.typeahead/typeahead-css-spec
  {:main {:class ["rc-typeahead"]}
   :wrapper {}
   :suggestions-container-wrapper {:style {:position "relative"}}
   :suggestions-container {}
   :throbber {}
   :suggestion {:class (fn [{:keys [selected?]}]
                         ["rc-typeahead-suggestion" (when selected? "active")])}})


(def px (memoize util/px))

(def re-com.v-table/scrollbar-css-spec
  {:main {:class (fn [{:keys [horizontal?]}]
                   [(str (if horizontal? "horizontal" "vertical") "-scrollbar")])
          :style (fn [{:keys [width horizontal? show? mouse-over? dragging?]}]
                   (merge {:border-radius (px (/ width 2))
                           :overflow "hidden"}
                          (when show?
                            {:background-color (if (or mouse-over? dragging?)
                                                 ;;scrollbar-hover-color
                                                 "#ccc"
                                                 ;;scrollbar-color
                                                 "#eee")})))}
   :thumb {:style (fn [{:keys [width mouse-over? dragging? horizontal? scroll-position]}]
                    {:border-radius (px (/ width 2))
                     :cursor "default"
                     :background-color
                     (case
                         dragging? "#777" ;thumb-drag-color
                         mouse-over? "#999" ;thumb-hover-color
                         :else "#bbb") ;thumb-color
                     (if horizontal? :margin-left :margin-top)
                     (px scroll-position)})}})


(def re-com.v-table/v-table-css-spec
  {:wrapper {:class ["rc-v-table"]
             :style (fn [{:keys [max-width max-height]}]
                      {:max-width max-width :max-height max-height})
             :use-toplevel true}

   :left-section {:class ["rc-v-table-left-section"]}
   :top-left {:class ["rc-v-table-top-left" "rc-v-table-content"]
              :style {:overflow "hidden"}}
   :row-headers {:class ["rc-v-table-row-headers" "rc-v-table-viewport"]
                 :style (fn [{:keys [max-height]}]
                          {:position "relative"
                           :overflow "hidden"
                           :max-height (px max-height)})}
   :row-header-selection-rect {}
   :row-header-content {:class ["rc-v-table-row-header-content" "rc-v-table-content"]
                        :style (fn [{:keys [scroll-y]}]
                                 {:margin-top (px scroll-y :negative)})}
   :bottom-left {:class ["rc-v-table-bottom-left" "rc-v-table-content"]
                 :style {:overflow "hidden"}}

   :middle-section {:class ["rc-v-table-middle-section"]
                    :style (fn [{:keys [max-width]}]
                             {:max-width max-width})}
   :column-headers {:class ["rc-v-table-column-headers" "rc-v-table-viewport"]
                    :style {:overflow "hidden"
                            :position "relative"}}
   :column-header-selection-rect {}
   :column-header-content {:class ["rc-v-table-column-header-content" "rc-v-table-content"]
                           :style (fn [{:keys [scroll-x]}]
                                    {:margin-left (px scroll-x :negative)})}

   :rows {:class ["rc-v-table-rows" "rc-v-table-viewport"]
          :style (fn [{:keys [max-height]}]
                   {:overflow "hidden"
                    :position "relative"
                    :max-height (px max-height)})}
   :row-selection-rect {}
   :row-content {:class ["rc-v-table-row-content" "rc-v-table-content"]
                 :style (fn [{:keys [scroll-x scroll-y]}]
                          {:margin-left (px scroll-x :negative)
                           :margin-top (px scroll-y :negative)})}
   :column-footers {:class ["rc-v-table-column-footers" "rc-v-table-viewport"]
                    :style {:overflow "hidden"}}
   :column-footer-content {:class ["rc-v-table-column-footer-content" "rc-v-table-content"]
                           :style (fn [{:keys [scroll-x]}]
                                    {:margin-left (px scroll-x :negative)})}

   :h-scroll {:class ["rc-v-table-h-scroll"]
              :style (fn [{:keys [scrollbar-margin]}]
                       {:margin (px-n scrollbar-margin 0)})}

   :right-section {:class ["rc-v-table-right-section"]}
   :top-right {:class ["rc-v-table-top-right" "rc-v-table-content"]
               :style {:overflow "hidden"}}
   :row-footers {:class ["rc-v-table-row-footers" "rc-v-table-viewport"]
                 :style (fn [{:keys [max-height]}]
                          {:max-height (px max-height)
                           :overflow "hidden"})}
   :row-footer-content {:class ["rc-v-table-row-footer-content" "rc-v-table-content"]
                        :style (fn [{:keys [scroll-y]}]
                                 {:margin-top (px scroll-y :negative)})}
   :bottom-right {:class ["rc-v-table-bottom-right" "rc-v-table-content"]
                  :style {:overflow "hidden"}}
   :v-scroll-section {:class ["rc-v-table-v-scroll-section"]}
   :v-scroll {:class ["rc-v-table-v-scroll"]
              :style (fn [{:keys [scrollbar-margin]}]
                       {:margin (px-n scrollbar-margin 0)})}
   })

;;This is for the selection-renderer component embedded in v-table. Perhaps it should be a key in
;; v-table-css-spec, above. But it doesn't seem to be addressable using `parts` so for now just has
;; its defaults defined in the separate structure below.
(def re-com.v-table/v-table-selection-css-spec
  {:main {:class ["rc-v-table-selection"]
          :style (fn [{:keys [top left width height]}]
                   {:top (px top) :left (px left) :width (px width) :height (px height)
                    :position "absolute"
                    :z-index 1
                    :background-color "rgba(0,0,255,0.1)"
                    :border "1px solid rgba(0,0,255,0.4)"})}})


