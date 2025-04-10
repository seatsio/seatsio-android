package io.seats.seatingChart;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import io.seats.CommonConfig;
import io.seats.utils.Function3;
import io.seats.utils.Function4;

public class SeatingChartConfig extends CommonConfig<SeatingChartConfig, SeatingChartView> {

    @Expose
    public String _client = "android";

    @Expose
    public String workspaceKey;

    @Expose
    private List<PricingForCategory> pricing;

    @Expose
    public Integer numberOfPlacesToSelect;

    @Expose
    public Boolean objectWithoutPricingSelectable;

    @Expose
    public List<SelectedObject> selectedObjects;

    @Expose
    public List<String> selectableObjects;

    @Expose
    public ObjectTooltip objectTooltip;

    @Expose
    public ThemePreset themePreset;

    @Expose
    public ThemeColors themeColors;

    @Expose
    public String priceLevelsTooltipMessage;

    @Expose
    public Object maxSelectedObjects;

    @Expose
    public List<String> unavailableCategories;

    @Expose
    public List<String> availableCategories;

    @Expose
    public BestAvailable selectBestAvailable;

    @Expose
    public Boolean alwaysShowSectionContents;

    @Expose
    public SeatingChartShowSectionContents showSectionContents;

    @Expose
    public Boolean showLegend;

    @Expose
    public Boolean showSeatLabels;

    @Expose
    public Legend legend;

    @Expose
    public Boolean multiSelectEnabled;

    @Expose
    public Boolean showMinimap;

    @Expose
    @SerializedName("showActiveSectionTooltipOnMobile")
    public Boolean showActiveSectionTooltip;

    @Expose
    @SerializedName("showViewFromYourSeatOnMobile")
    public Boolean showViewFromYourSeat;

    @Expose
    public List<SelectionValidator> selectionValidators;

    @Expose
    public List<Category> categories;

    @Expose
    public Map<String, String> objectCategories;

    @Expose
    public SeatingChartMode mode;

    @Expose
    public String loading;

    @Expose
    public List<TicketListing> ticketListings;

    @Expose
    public String chart;

    @Expose
    public Boolean holdOnSelectForGAs;

    @Expose
    public String holdToken;

    @Expose
    public SeatingChartSession session;

    @Expose
    public Collection<String> channels;

    @Expose
    public String activeFloor;

    @Expose
    public Boolean lockActiveFloor;

    @Expose
    public Boolean showFloorElevator;

    @Expose
    public Boolean showSectionPricingOverlay;

    @Expose
    public CategoryFilter categoryFilter;

    @Expose
    public Boolean unifiedObjectPropertiesInCallbacks;

    @Expose
    public Boolean hideSectionsNotForSale;

    @Expose
    public ObjectPopover objectPopover;

    public Object canGASelectionBeIncreased;

    public Object isObjectVisible;

    public Object objectLabel;

    public Object objectIcon;

    public Object sectionColor;

    public Object onBestAvailableSelected;
    public Object onHoldSucceeded;
    public Object onHoldFailed;
    public Object onReleaseHoldSucceeded;
    public Object onReleaseHoldFailed;
    public Object onBestAvailableSelectionFailed;
    public Object onSelectionValid;
    public Object onSelectionInvalid;
    public Object onHoldCallsInProgress;
    public Object onHoldCallsComplete;
    public Object onSelectedObjectBooked;
    public Object onObjectStatusChanged;
    public Object onSessionInitialized;
    public Object onFilteredCategoriesChanged;
    public Object onFloorChanged;
    public Object onHoldTokenExpired;
    public Object priceFormatter;
    public Object onPlacesPrompt;
    public Object onPlacesWithTicketTypesPrompt;
    public Object onTicketTypePrompt;

    public SeatingChartConfig setWorkspaceKey(String workspaceKey) {
        this.workspaceKey = workspaceKey;
        return this;
    }

    public SeatingChartConfig setPricing(PricingForCategory... pricing) {
        this.pricing = asList(pricing);
        return this;
    }

    public SeatingChartConfig setNumberOfPlacesToSelect(Integer numberOfPlacesToSelect) {
        this.numberOfPlacesToSelect = numberOfPlacesToSelect;
        return this;
    }

    public SeatingChartConfig setOnBestAvailableSelected(BiConsumer<List<SeatsioObject>, Boolean> onBestAvailableSelected) {
        this.onBestAvailableSelected = onBestAvailableSelected;
        return this;
    }

    public SeatingChartConfig setOnBestAvailableSelected(String onBestAvailableSelected) {
        this.onBestAvailableSelected = onBestAvailableSelected;
        return this;
    }

    public SeatingChartConfig setOnBestAvailableSelectionFailed(Runnable onBestAvailableSelectionFailed) {
        this.onBestAvailableSelectionFailed = onBestAvailableSelectionFailed;
        return this;
    }

    public SeatingChartConfig setOnBestAvailableSelectionFailed(String onBestAvailableSelectionFailed) {
        this.onBestAvailableSelectionFailed = onBestAvailableSelectionFailed;
        return this;
    }

    public SeatingChartConfig setOnHoldSucceeded(BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldSucceeded) {
        this.onHoldSucceeded = onHoldSucceeded;
        return this;
    }

    public SeatingChartConfig setOnHoldSucceeded(String onHoldSucceeded) {
        this.onHoldSucceeded = onHoldSucceeded;
        return this;
    }

    public SeatingChartConfig setOnHoldFailed(BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldFailed) {
        this.onHoldFailed = onHoldFailed;
        return this;
    }

    public SeatingChartConfig setOnHoldFailed(String onHoldFailed) {
        this.onHoldFailed = onHoldFailed;
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldSucceeded(BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldSucceeded) {
        this.onReleaseHoldSucceeded = onReleaseHoldSucceeded;
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldSucceeded(String onReleaseHoldSucceeded) {
        this.onReleaseHoldSucceeded = onReleaseHoldSucceeded;
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldFailed(BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldFailed) {
        this.onReleaseHoldFailed = onReleaseHoldFailed;
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldFailed(String onReleaseHoldFailed) {
        this.onReleaseHoldFailed = onReleaseHoldFailed;
        return this;
    }

    public SeatingChartConfig setOnSelectionValid(Runnable onSelectionValid) {
        this.onSelectionValid = onSelectionValid;
        return this;
    }

    public SeatingChartConfig setOnSelectionValid(String onSelectionValid) {
        this.onSelectionValid = onSelectionValid;
        return this;
    }

    public SeatingChartConfig setOnSelectionInvalid(Consumer<List<SelectionValidatorType>> onSelectionInvalid) {
        this.onSelectionInvalid = onSelectionInvalid;
        return this;
    }

    public SeatingChartConfig setOnSelectionInvalid(String onSelectionInvalid) {
        this.onSelectionInvalid = onSelectionInvalid;
        return this;
    }

    public SeatingChartConfig setOnHoldCallsInProgress(Runnable onHoldCallsInProgress) {
        this.onHoldCallsInProgress = onHoldCallsInProgress;
        return this;
    }

    public SeatingChartConfig setOnHoldCallsInProgress(String onHoldCallsInProgress) {
        this.onHoldCallsInProgress = onHoldCallsInProgress;
        return this;
    }

    public SeatingChartConfig setOnHoldCallsComplete(Runnable onHoldCallsComplete) {
        this.onHoldCallsComplete = onHoldCallsComplete;
        return this;
    }

    public SeatingChartConfig setOnHoldCallsComplete(String onHoldCallsComplete) {
        this.onHoldCallsComplete = onHoldCallsComplete;
        return this;
    }

    public SeatingChartConfig setOnSelectedObjectBooked(Consumer<SeatsioObject> onSelectedObjectBooked) {
        this.onSelectedObjectBooked = onSelectedObjectBooked;
        return this;
    }

    public SeatingChartConfig setOnSelectedObjectBooked(String onSelectedObjectBooked) {
        this.onSelectedObjectBooked = onSelectedObjectBooked;
        return this;
    }

    public SeatingChartConfig setOnObjectStatusChanged(Consumer<SeatsioObject> onObjectStatusChanged) {
        this.onObjectStatusChanged = onObjectStatusChanged;
        return this;
    }

    public SeatingChartConfig setOnObjectStatusChanged(String onObjectStatusChanged) {
        this.onObjectStatusChanged = onObjectStatusChanged;
        return this;
    }

    public SeatingChartConfig setOnSessionInitialized(Consumer<HoldToken> onSessionInitialized) {
        this.onSessionInitialized = onSessionInitialized;
        return this;
    }

    public SeatingChartConfig setOnSessionInitialized(String onSessionInitialized) {
        this.onSessionInitialized = onSessionInitialized;
        return this;
    }

    public SeatingChartConfig setOnHoldTokenExpired(Runnable onHoldTokenExpired) {
        this.onHoldTokenExpired = onHoldTokenExpired;
        return this;
    }

    public SeatingChartConfig setOnHoldTokenExpired(String onHoldTokenExpired) {
        this.onHoldTokenExpired = onHoldTokenExpired;
        return this;
    }

    public SeatingChartConfig setOnFilteredCategoriesChanged(Consumer<List<Category>> onFilteredCategoriesChanged) {
        this.onFilteredCategoriesChanged = onFilteredCategoriesChanged;
        return this;
    }

    public SeatingChartConfig setOnFilteredCategoriesChanged(String onFilteredCategoriesChanged) {
        this.onFilteredCategoriesChanged = onFilteredCategoriesChanged;
        return this;
    }

    public SeatingChartConfig setOnFloorChanged(Consumer<Floor> onFloorChanged) {
        this.onFloorChanged = onFloorChanged;
        return this;
    }

    public SeatingChartConfig setOnFloorChanged(String onFloorChanged) {
        this.onFloorChanged = onFloorChanged;
        return this;
    }

    public SeatingChartConfig setPriceFormatter(Function<Float, String> priceFormatter) {
        this.priceFormatter = priceFormatter;
        return this;
    }

    public SeatingChartConfig setPriceFormatter(String priceFormatter) {
        this.priceFormatter = priceFormatter;
        return this;
    }

    public SeatingChartConfig setObjectWithoutPricingSelectable(boolean objectWithoutPricingSelectable) {
        this.objectWithoutPricingSelectable = objectWithoutPricingSelectable;
        return this;
    }

    public SeatingChartConfig setSelectedObjects(String... selectedObjects) {
        this.selectedObjects = stream(selectedObjects)
                .map(SelectedObject::new)
                .collect(toList());
        return this;
    }

    public SeatingChartConfig setSelectedObjects(SelectedObject... selectedObjects) {
        this.selectedObjects = asList(selectedObjects);
        return this;
    }

    public SeatingChartConfig setSelectableObjects(String... selectableObjects) {
        this.selectableObjects = Arrays.asList(selectableObjects);
        return this;
    }

    public SeatingChartConfig setObjectTooltip(ObjectTooltip objectTooltip) {
        this.objectTooltip = objectTooltip;
        return this;
    }

    public SeatingChartConfig setThemePreset(ThemePreset themePreset) {
        this.themePreset = themePreset;
        return this;
    }

    public SeatingChartConfig setThemeColors(ThemeColors themeColors) {
        this.themeColors = themeColors;
        return this;
    }

    public SeatingChartConfig withPriceLevelsTooltipMessage(String priceLevelsTooltipMessage) {
        this.priceLevelsTooltipMessage = priceLevelsTooltipMessage;
        return this;
    }

    public SeatingChartConfig setMaxSelectedObjects(int maxSelectedObjects) {
        this.maxSelectedObjects = maxSelectedObjects;
        return this;
    }

    public SeatingChartConfig setMaxSelectedObjects(CategoryWithQuantity... maxSelectedObjects) {
        this.maxSelectedObjects = asList(maxSelectedObjects);
        return this;
    }

    public SeatingChartConfig setMaxSelectedObjects(TicketTypeWithQuantity... maxSelectedObjects) {
        this.maxSelectedObjects = asList(maxSelectedObjects);
        return this;
    }

    public SeatingChartConfig setMaxSelectedObjects(CategoryWithTicketTypesAndQuantity... maxSelectedObjects) {
        this.maxSelectedObjects = asList(maxSelectedObjects);
        return this;
    }

    public SeatingChartConfig setUnavailableCategories(String... unavailableCategories) {
        this.unavailableCategories = asList(unavailableCategories);
        return this;
    }

    public SeatingChartConfig setAvailableCategories(String... availableCategories) {
        this.availableCategories = asList(availableCategories);
        return this;
    }

    public SeatingChartConfig setSelectBestAvailable(BestAvailable selectBestAvailable) {
        this.selectBestAvailable = selectBestAvailable;
        return this;
    }

    @Deprecated
    public SeatingChartConfig setAlwaysShowSectionContents(boolean alwaysShowSectionContents) {
        this.alwaysShowSectionContents = alwaysShowSectionContents;
        return this;
    }

    public SeatingChartConfig setShowSectionContents(SeatingChartShowSectionContents showSectionContents) {
        this.showSectionContents = showSectionContents;
        return this;
    }

    public SeatingChartConfig setShowLegend(boolean showLegend) {
        this.showLegend = showLegend;
        return this;
    }

    public SeatingChartConfig setShowSeatLabels(boolean showSeatLabels) {
        this.showSeatLabels = showSeatLabels;
        return this;
    }

    public SeatingChartConfig setLegend(Legend legend) {
        this.legend = legend;
        return this;
    }

    public SeatingChartConfig setMultiSelectEnabled(boolean multiSelectEnabled) {
        this.multiSelectEnabled = multiSelectEnabled;
        return this;
    }

    public SeatingChartConfig setShowMinimap(boolean showMinimap) {
        this.showMinimap = showMinimap;
        return this;
    }

    public SeatingChartConfig setShowActiveSectionTooltip(boolean showActiveSectionTooltip) {
        this.showActiveSectionTooltip = showActiveSectionTooltip;
        return this;
    }

    public SeatingChartConfig setShowViewFromYourSeat(boolean showViewFromYourSeat) {
        this.showViewFromYourSeat = showViewFromYourSeat;
        return this;
    }

    public SeatingChartConfig setSelectionValidators(SelectionValidator... selectionValidators) {
        this.selectionValidators = asList(selectionValidators);
        return this;
    }

    public SeatingChartConfig setCategories(Category... categories) {
        this.categories = asList(categories);
        return this;
    }

    public SeatingChartConfig setObjectCategories(Map<String, String> objectCategories) {
        this.objectCategories = objectCategories;
        return this;
    }

    public SeatingChartConfig setMode(SeatingChartMode mode) {
        this.mode = mode;
        return this;
    }

    public SeatingChartConfig setLoading(String loading) {
        this.loading = loading;
        return this;
    }

    public SeatingChartConfig setTicketListings(TicketListing... ticketListings) {
        this.ticketListings = asList(ticketListings);
        return this;
    }

    public SeatingChartConfig setChart(String chart) {
        this.chart = chart;
        return this;
    }

    public SeatingChartConfig setHoldOnSelectForGAs(boolean holdOnSelectForGAs) {
        this.holdOnSelectForGAs = holdOnSelectForGAs;
        return this;
    }

    public SeatingChartConfig setHoldToken(String holdToken) {
        this.holdToken = holdToken;
        return this;
    }

    public SeatingChartConfig setSession(SeatingChartSession session) {
        this.session = session;
        return this;
    }

    public SeatingChartConfig setObjectLabel(Function3<SeatsioObject, String, Map<String, ?>, String> objectLabel) {
        this.objectLabel = objectLabel;
        return this;
    }

    public SeatingChartConfig setObjectLabel(String objectLabel) {
        this.objectLabel = objectLabel;
        return this;
    }

    public SeatingChartConfig setObjectIcon(Function3<SeatsioObject, String, Map<String, ?>, String> objectIcon) {
        this.objectIcon = objectIcon;
        return this;
    }

    public SeatingChartConfig setObjectIcon(String objectIcon) {
        this.objectIcon = objectIcon;
        return this;
    }

    public SeatingChartConfig setIsObjectVisible(BiFunction<SeatsioObject, Map<String, ?>, Boolean> isObjectVisible) {
        this.isObjectVisible = isObjectVisible;
        return this;
    }

    public SeatingChartConfig setIsObjectVisible(String isObjectVisible) {
        this.isObjectVisible = isObjectVisible;
        return this;
    }

    public SeatingChartConfig setCanGASelectionBeIncreased(Function4<SeatsioObject, Boolean, Map<String, ?>, TicketTypePricing, Boolean> canGASelectionBeIncreased) {
        this.canGASelectionBeIncreased = canGASelectionBeIncreased;
        return this;
    }

    public SeatingChartConfig setCanGASelectionBeIncreased(String canGASelectionBeIncreased) {
        this.canGASelectionBeIncreased = canGASelectionBeIncreased;
        return this;
    }

    public SeatingChartConfig setSectionColor(Function3<Section, String, Map<String, ?>, String> sectionColor) {
        this.sectionColor = sectionColor;
        return this;
    }

    public SeatingChartConfig setSectionColor(String sectionColor) {
        this.sectionColor = sectionColor;
        return this;
    }

    public SeatingChartConfig setChannels(Collection<String> channelKeys) {
        this.channels = channelKeys;
        return this;
    }

    public SeatingChartConfig setActiveFloor(String activeFloor) {
        this.activeFloor = activeFloor;
        return this;
    }

    public SeatingChartConfig setLockActiveFloor(Boolean lockActiveFloor) {
        this.lockActiveFloor = lockActiveFloor;
        return this;
    }

    public SeatingChartConfig setShowFloorElevator(Boolean showFloorElevator) {
        this.showFloorElevator = showFloorElevator;
        return this;
    }

    public SeatingChartConfig setShowSectionPricingOverlay(Boolean showSectionPricingOverlay) {
        this.showSectionPricingOverlay = showSectionPricingOverlay;
        return this;
    }

    public SeatingChartConfig setCategoryFilter(CategoryFilter categoryFilter) {
        this.categoryFilter = categoryFilter;
        return this;
    }

    public SeatingChartConfig setUnifiedObjectPropertiesInCallbacks(Boolean unifiedObjectPropertiesInCallbacks) {
        this.unifiedObjectPropertiesInCallbacks = unifiedObjectPropertiesInCallbacks;
        return this;
    }

    public SeatingChartConfig setHideSectionsNotForSale(Boolean hideSectionsNotForSale) {
        this.hideSectionsNotForSale = hideSectionsNotForSale;
        return this;
    }

    public SeatingChartConfig setObjectPopover(ObjectPopover objectPopover) {
        this.objectPopover = objectPopover;
        return this;
    }

    public SeatingChartConfig setOnPlacesPrompt(BiConsumer<PromptsApiParams.OnPlacesPromptParams, Consumer<Integer>> onPlacesPrompt) {
        this.onPlacesPrompt = onPlacesPrompt;
        return this;
    }

    public SeatingChartConfig setOnPlacesPrompt(String onPlacesPrompt) {
        this.onPlacesPrompt = onPlacesPrompt;
        return this;
    }

    public SeatingChartConfig setOnPlacesWithTicketTypesPrompt(BiConsumer<PromptsApiParams.OnPlacesWithTicketTypesPromptParams, Consumer<Map<String, Integer>>> onPlacesWithTicketTypesPrompt) {
        this.onPlacesWithTicketTypesPrompt = onPlacesWithTicketTypesPrompt;
        return this;
    }

    public SeatingChartConfig setOnPlacesWithTicketTypesPrompt(String onPlacesWithTicketTypesPrompt) {
        this.onPlacesWithTicketTypesPrompt = onPlacesWithTicketTypesPrompt;
        return this;
    }

    public SeatingChartConfig setOnTicketTypePrompt(BiConsumer<PromptsApiParams.OnTicketTypePromptParams, Consumer<String>> onTicketTypePrompt) {
        this.onTicketTypePrompt = onTicketTypePrompt;
        return this;
    }

    public SeatingChartConfig setOnTicketTypePrompt(String onTicketTypePrompt) {
        this.onTicketTypePrompt = onTicketTypePrompt;
        return this;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (onBestAvailableSelected != null) {
            if (onBestAvailableSelected instanceof String) {
                callbacks.add("onBestAvailableSelected: " + onBestAvailableSelected);
            } else {
                callbacks.add("onBestAvailableSelected: (objects, nextToEachOther) => Native.onBestAvailableSelected(JSON.stringify(objects), nextToEachOther)");
            }
        }

        if (onBestAvailableSelectionFailed != null) {
            if (onBestAvailableSelectionFailed instanceof String) {
                callbacks.add("onBestAvailableSelectionFailed: " + onBestAvailableSelectionFailed);
            } else {
                callbacks.add("onBestAvailableSelectionFailed: () => Native.onBestAvailableSelectionFailed()");
            }
        }

        if (onSessionInitialized != null) {
            if (onSessionInitialized instanceof String) {
                callbacks.add("onSessionInitialized: " + onSessionInitialized);
            } else {
                callbacks.add("onSessionInitialized: (holdToken) => Native.onSessionInitialized(JSON.stringify(holdToken))");
            }
        }

        if (onHoldTokenExpired != null) {
            if (onHoldTokenExpired instanceof String) {
                callbacks.add("onHoldTokenExpired: " + onHoldTokenExpired);
            } else {
                callbacks.add("onHoldTokenExpired: () => Native.onHoldTokenExpired()");
            }
        }

        if (onHoldSucceeded != null) {
            if (onHoldSucceeded instanceof String) {
                callbacks.add("onHoldSucceeded: " + onHoldSucceeded);
            } else {
                callbacks.add("onHoldSucceeded: (objects, ticketTypes) => Native.onHoldSucceeded(JSON.stringify(objects), JSON.stringify(ticketTypes))");
            }
        }

        if (onHoldFailed != null) {
            if (onHoldFailed instanceof String) {
                callbacks.add("onHoldFailed: " + onHoldFailed);
            } else {
                callbacks.add("onHoldFailed: (objects, ticketTypes) => Native.onHoldFailed(JSON.stringify(objects), JSON.stringify(ticketTypes))");
            }
        }

        if (onReleaseHoldSucceeded != null) {
            if (onReleaseHoldSucceeded instanceof String) {
                callbacks.add("onReleaseHoldSucceeded: " + onReleaseHoldSucceeded);
            } else {
                callbacks.add("onReleaseHoldSucceeded: (objects, ticketTypes) => Native.onReleaseHoldSucceeded(JSON.stringify(objects), JSON.stringify(ticketTypes))");
            }
        }

        if (onReleaseHoldFailed != null) {
            if (onReleaseHoldFailed instanceof String) {
                callbacks.add("onReleaseHoldFailed: " + onReleaseHoldFailed);
            } else {
                callbacks.add("onReleaseHoldFailed: (objects, ticketTypes) => Native.onReleaseHoldFailed(JSON.stringify(objects), JSON.stringify(ticketTypes))");
            }
        }

        if (onSelectionValid != null) {
            if (onSelectionValid instanceof String) {
                callbacks.add("onSelectionValid: " + onSelectionValid);
            } else {
                callbacks.add("onSelectionValid: () => Native.onSelectionValid()");
            }
        }

        if (onSelectionInvalid != null) {
            if (onSelectionInvalid instanceof String) {
                callbacks.add("onSelectionInvalid: " + onSelectionInvalid);
            } else {
                callbacks.add("onSelectionInvalid: (violations) => Native.onSelectionInvalid(JSON.stringify(violations))");
            }
        }

        if (onHoldCallsInProgress != null) {
            if (onHoldCallsInProgress instanceof String) {
                callbacks.add("onHoldCallsInProgress: " + onHoldCallsInProgress);
            } else {
                callbacks.add("onHoldCallsInProgress: () => Native.onHoldCallsInProgress()");
            }
        }

        if (onHoldCallsComplete != null) {
            if (onHoldCallsComplete instanceof String) {
                callbacks.add("onHoldCallsComplete: " + onHoldCallsComplete);
            } else {
                callbacks.add("onHoldCallsComplete: () => Native.onHoldCallsComplete()");
            }
        }

        if (onSelectedObjectBooked != null) {
            if (onSelectedObjectBooked instanceof String) {
                callbacks.add("onSelectedObjectBooked: " + onSelectedObjectBooked);
            } else {
                callbacks.add("onSelectedObjectBooked: (object) => Native.onSelectedObjectBooked(JSON.stringify(object))");
            }
        }

        if (onObjectStatusChanged != null) {
            if (onObjectStatusChanged instanceof String) {
                callbacks.add("onObjectStatusChanged: " + onObjectStatusChanged);
            } else {
                callbacks.add("onObjectStatusChanged: (object) => Native.onObjectStatusChanged(JSON.stringify(object))");
            }
        }

        if (onFilteredCategoriesChanged != null) {
            if (onFilteredCategoriesChanged instanceof String) {
                callbacks.add("onFilteredCategoriesChanged: " + onFilteredCategoriesChanged);
            } else {
                callbacks.add("onFilteredCategoriesChanged: (categories) => Native.onFilteredCategoriesChanged(JSON.stringify(categories))");
            }
        }

        if (onFloorChanged != null) {
            if (onFloorChanged instanceof String) {
                callbacks.add("onFloorChanged: " + onFloorChanged);
            } else {
                callbacks.add("onFloorChanged: (floor) => Native.onFloorChanged(JSON.stringify(floor))");
            }
        }

        if (priceFormatter != null) {
            if (priceFormatter instanceof String) {
                callbacks.add("priceFormatter: " + priceFormatter);
            } else {
                callbacks.add("priceFormatter: (price) => Native.formatPrice(price)");
            }
        }

        if (objectLabel != null) {
            if (objectLabel instanceof String) {
                callbacks.add("objectLabel: " + objectLabel);
            } else {
                callbacks.add("objectLabel: (object, defaultLabel, extraConfig) =>  Native.objectLabel(JSON.stringify(object), defaultLabel, extraConfig)");
            }
        }

        if (objectIcon != null) {
            if (objectIcon instanceof String) {
                callbacks.add("objectIcon: " + objectIcon);
            } else {
                callbacks.add("objectIcon: (object, defaultLabel, extraConfig) => Native.objectIcon(JSON.stringify(object), defaultLabel, extraConfig)");
            }
        }

        if (isObjectVisible != null) {
            if (isObjectVisible instanceof String) {
                callbacks.add("isObjectVisible: " + isObjectVisible);
            } else {
                callbacks.add("isObjectVisible: (object, extraConfig) => Native.isObjectVisible(JSON.stringify(object), extraConfig)");
            }
        }

        if (canGASelectionBeIncreased != null) {
            if (canGASelectionBeIncreased instanceof String) {
                callbacks.add("canGASelectionBeIncreased: " + canGASelectionBeIncreased);
            } else {
                callbacks.add("canGASelectionBeIncreased: (gaArea, defaultValue, extraConfig, ticketType) => Native.canGASelectionBeIncreased(JSON.stringify(object), defaultValue, extraConfig, ticketType)");
            }
        }

        if (sectionColor != null) {
            if (sectionColor instanceof String) {
                callbacks.add("sectionColor: " + sectionColor);
            } else {
                callbacks.add("sectionColor: (section, defaultColor, extraConfig) => Native.sectionColor(JSON.stringify(section), defaultColor, extraConfig)");
            }
        }

        if (onPlacesPrompt != null) {
            if (onPlacesPrompt instanceof String) {
                callbacks.add("onPlacesPrompt: " + onPlacesPrompt);
            } else {
                callbacks.add("onPlacesPrompt: (params, callback) => { registerInternalCallback('onPlacesPrompt', callback); Native.onPlacesPrompt(JSON.stringify(params)) }");
            }
        }

        if (onPlacesWithTicketTypesPrompt != null) {
            if (onPlacesWithTicketTypesPrompt instanceof String) {
                callbacks.add("onPlacesWithTicketTypesPrompt: " + onPlacesWithTicketTypesPrompt);
            } else {
                callbacks.add("onPlacesWithTicketTypesPrompt: (params, callback) => { registerInternalCallback('onPlacesWithTicketTypesPrompt', callback); Native.onPlacesWithTicketTypesPrompt(JSON.stringify(params)) }");
            }
        }

        if (onTicketTypePrompt != null) {
            if (onTicketTypePrompt instanceof String) {
                callbacks.add("onTicketTypePrompt: " + onTicketTypePrompt);
            } else {
                callbacks.add("onTicketTypePrompt: (params, callback) => { registerInternalCallback('onTicketTypePrompt', callback); Native.onTicketTypePrompt(JSON.stringify(params)) }");
            }
        }

        return callbacks;
    }
}
