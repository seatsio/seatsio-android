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
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import io.seats.CommonConfig;
import io.seats.utils.Function3;
import io.seats.utils.Function4;

public class SeatingChartConfig extends CommonConfig<SeatingChartConfig, SeatingChartView> {

    @Expose
    public String _client = "android";

    @Expose
    public String workspaceKey;

    @Expose
    public SeatsioPricing pricing;

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
    public CategoryFilter categoryFilter;

    @Expose
    public final Boolean unifiedObjectPropertiesInCallbacks = true;

    @Expose
    public Boolean hideSectionsNotForSale;

    @Expose
    public ObjectPopover objectPopover;

    public Function4<SeatsioObject, Boolean, Map<String, ?>, TicketTypePricing, Boolean> canGASelectionBeIncreased;

    public String isObjectVisibleJavaScriptFunction;
    public String objectLabelJavaScriptFunction;
    public String objectIconJavaScriptFunction;
    public Function3<Section, String, Map<String, ?>, String> sectionColor;

    public BiConsumer<List<SeatsioObject>, Boolean> onBestAvailableSelected;
    public BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldSucceeded;
    public BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldFailed;
    public BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldSucceeded;
    public BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldFailed;
    public Runnable onBestAvailableSelectionFailed;
    public Runnable onSelectionValid;
    public Consumer<List<SelectionValidatorType>> onSelectionInvalid;
    public Runnable onHoldCallsInProgress;
    public Runnable onHoldCallsComplete;
    public Consumer<SeatsioObject> onSelectedObjectBooked;
    public Consumer<SeatsioObject> onObjectStatusChanged;
    public Consumer<HoldToken> onSessionInitialized;
    public Consumer<List<Category>> onFilteredCategoriesChanged;
    public Consumer<Floor> onFloorChanged;
    public Runnable onHoldTokenExpired;
    public BiConsumer<PromptsApiParams.OnPlacesPromptParams, Consumer<Integer>> onPlacesPrompt;
    public BiConsumer<PromptsApiParams.OnPlacesWithTicketTypesPromptParams, Consumer<Map<String, Integer>>> onPlacesWithTicketTypesPrompt;
    public BiConsumer<PromptsApiParams.OnTicketTypePromptParams, Consumer<String>> onTicketTypePrompt;

    @Expose
    public UUID ticketBuyerId;

    public SeatingChartConfig setWorkspaceKey(String workspaceKey) {
        this.workspaceKey = workspaceKey;
        return this;
    }

    public SeatingChartConfig setPricing(SeatsioPricing pricing) {
        this.pricing = pricing;
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

    public SeatingChartConfig setOnBestAvailableSelectionFailed(Runnable onBestAvailableSelectionFailed) {
        this.onBestAvailableSelectionFailed = onBestAvailableSelectionFailed;
        return this;
    }

    public SeatingChartConfig setOnHoldSucceeded(BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldSucceeded) {
        this.onHoldSucceeded = onHoldSucceeded;
        return this;
    }

    public SeatingChartConfig setOnHoldFailed(BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldFailed) {
        this.onHoldFailed = onHoldFailed;
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldSucceeded(BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldSucceeded) {
        this.onReleaseHoldSucceeded = onReleaseHoldSucceeded;
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldFailed(BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldFailed) {
        this.onReleaseHoldFailed = onReleaseHoldFailed;
        return this;
    }

    public SeatingChartConfig setOnSelectionValid(Runnable onSelectionValid) {
        this.onSelectionValid = onSelectionValid;
        return this;
    }

    public SeatingChartConfig setOnSelectionInvalid(Consumer<List<SelectionValidatorType>> onSelectionInvalid) {
        this.onSelectionInvalid = onSelectionInvalid;
        return this;
    }

    public SeatingChartConfig setOnHoldCallsInProgress(Runnable onHoldCallsInProgress) {
        this.onHoldCallsInProgress = onHoldCallsInProgress;
        return this;
    }

    public SeatingChartConfig setOnHoldCallsComplete(Runnable onHoldCallsComplete) {
        this.onHoldCallsComplete = onHoldCallsComplete;
        return this;
    }

    public SeatingChartConfig setOnSelectedObjectBooked(Consumer<SeatsioObject> onSelectedObjectBooked) {
        this.onSelectedObjectBooked = onSelectedObjectBooked;
        return this;
    }

    public SeatingChartConfig setOnObjectStatusChanged(Consumer<SeatsioObject> onObjectStatusChanged) {
        this.onObjectStatusChanged = onObjectStatusChanged;
        return this;
    }

    public SeatingChartConfig setOnSessionInitialized(Consumer<HoldToken> onSessionInitialized) {
        this.onSessionInitialized = onSessionInitialized;
        return this;
    }

    public SeatingChartConfig setOnHoldTokenExpired(Runnable onHoldTokenExpired) {
        this.onHoldTokenExpired = onHoldTokenExpired;
        return this;
    }

    public SeatingChartConfig setOnFilteredCategoriesChanged(Consumer<List<Category>> onFilteredCategoriesChanged) {
        this.onFilteredCategoriesChanged = onFilteredCategoriesChanged;
        return this;
    }

    public SeatingChartConfig setOnFloorChanged(Consumer<Floor> onFloorChanged) {
        this.onFloorChanged = onFloorChanged;
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

    public SeatingChartConfig setObjectLabelJavaScriptFunction(String objectLabelJavaScriptFunction) {
        this.objectLabelJavaScriptFunction = objectLabelJavaScriptFunction;
        return this;
    }

    public SeatingChartConfig setObjectIconJavaScriptFunction(String objectIconJavaScriptFunction) {
        this.objectIconJavaScriptFunction = objectIconJavaScriptFunction;
        return this;
    }

    public SeatingChartConfig setIsObjectVisibleJavaScriptFunction(String isObjectVisibleJavaScriptFunction) {
        this.isObjectVisibleJavaScriptFunction = isObjectVisibleJavaScriptFunction;
        return this;
    }

    public SeatingChartConfig setCanGASelectionBeIncreased(Function4<SeatsioObject, Boolean, Map<String, ?>, TicketTypePricing, Boolean> canGASelectionBeIncreased) {
        this.canGASelectionBeIncreased = canGASelectionBeIncreased;
        return this;
    }

    public SeatingChartConfig setSectionColor(Function3<Section, String, Map<String, ?>, String> sectionColor) {
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

    public SeatingChartConfig setCategoryFilter(CategoryFilter categoryFilter) {
        this.categoryFilter = categoryFilter;
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

    public SeatingChartConfig setOnPlacesWithTicketTypesPrompt(BiConsumer<PromptsApiParams.OnPlacesWithTicketTypesPromptParams, Consumer<Map<String, Integer>>> onPlacesWithTicketTypesPrompt) {
        this.onPlacesWithTicketTypesPrompt = onPlacesWithTicketTypesPrompt;
        return this;
    }

    public SeatingChartConfig setOnTicketTypePrompt(BiConsumer<PromptsApiParams.OnTicketTypePromptParams, Consumer<String>> onTicketTypePrompt) {
        this.onTicketTypePrompt = onTicketTypePrompt;
        return this;
    }

    public SeatingChartConfig setTicketBuyerId(UUID ticketBuyerId) {
        this.ticketBuyerId = ticketBuyerId;
        return this;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (onBestAvailableSelected != null) {
            callbacks.add("onBestAvailableSelected: (objects, nextToEachOther) => Native.onBestAvailableSelected(JSON.stringify(objects), nextToEachOther)");
        }

        if (onBestAvailableSelectionFailed != null) {
            callbacks.add("onBestAvailableSelectionFailed: () => Native.onBestAvailableSelectionFailed()");
        }

        if (onSessionInitialized != null) {
            callbacks.add("onSessionInitialized: (holdToken) => Native.onSessionInitialized(JSON.stringify(holdToken))");
        }

        if (onHoldTokenExpired != null) {
            callbacks.add("onHoldTokenExpired: () => Native.onHoldTokenExpired()");
        }

        if (onHoldSucceeded != null) {
            callbacks.add("onHoldSucceeded: (objects, ticketTypes) => Native.onHoldSucceeded(JSON.stringify(objects), JSON.stringify(ticketTypes))");
        }

        if (onHoldFailed != null) {
            callbacks.add("onHoldFailed: (objects, ticketTypes) => Native.onHoldFailed(JSON.stringify(objects), JSON.stringify(ticketTypes))");
        }

        if (onReleaseHoldSucceeded != null) {
            callbacks.add("onReleaseHoldSucceeded: (objects, ticketTypes) => Native.onReleaseHoldSucceeded(JSON.stringify(objects), JSON.stringify(ticketTypes))");
        }

        if (onReleaseHoldFailed != null) {
            callbacks.add("onReleaseHoldFailed: (objects, ticketTypes) => Native.onReleaseHoldFailed(JSON.stringify(objects), JSON.stringify(ticketTypes))");
        }

        if (onSelectionValid != null) {
            callbacks.add("onSelectionValid: () => Native.onSelectionValid()");
        }

        if (onSelectionInvalid != null) {
            callbacks.add("onSelectionInvalid: (violations) => Native.onSelectionInvalid(JSON.stringify(violations))");
        }

        if (onHoldCallsInProgress != null) {
            callbacks.add("onHoldCallsInProgress: () => Native.onHoldCallsInProgress()");
        }

        if (onHoldCallsComplete != null) {
            callbacks.add("onHoldCallsComplete: () => Native.onHoldCallsComplete()");
        }

        if (onSelectedObjectBooked != null) {
            callbacks.add("onSelectedObjectBooked: (object) => Native.onSelectedObjectBooked(JSON.stringify(object))");
        }

        if (onObjectStatusChanged != null) {
            callbacks.add("onObjectStatusChanged: (object) => Native.onObjectStatusChanged(JSON.stringify(object))");
        }

        if (onFilteredCategoriesChanged != null) {
            callbacks.add("onFilteredCategoriesChanged: (categories) => Native.onFilteredCategoriesChanged(JSON.stringify(categories))");
        }

        if (onFloorChanged != null) {
            callbacks.add("onFloorChanged: (floor) => Native.onFloorChanged(JSON.stringify(floor))");
        }

        if (objectLabelJavaScriptFunction != null) {
            callbacks.add("objectLabel: " + objectLabelJavaScriptFunction);
        }

        if (objectIconJavaScriptFunction != null) {
            callbacks.add("objectIcon: " + objectIconJavaScriptFunction);
        }

        if (isObjectVisibleJavaScriptFunction != null) {
            callbacks.add("isObjectVisible: " + isObjectVisibleJavaScriptFunction);
        }

        if (canGASelectionBeIncreased != null) {
            callbacks.add("canGASelectionBeIncreased: (gaArea, defaultValue, extraConfig, ticketType) => Native.x(JSON.stringify(object), defaultValue, extraConfig, ticketType)");
        }

        if (sectionColor != null) {
            callbacks.add("sectionColor: (section, defaultColor, extraConfig) => Native.sectionColor(JSON.stringify(section), defaultColor, extraConfig)");
        }

        if (onPlacesPrompt != null) {
            callbacks.add("onPlacesPrompt: (params, callback) => { registerInternalCallback('onPlacesPrompt', callback); Native.onPlacesPrompt(JSON.stringify(params)) }");
        }

        if (onPlacesWithTicketTypesPrompt != null) {
            callbacks.add("onPlacesWithTicketTypesPrompt: (params, callback) => { registerInternalCallback('onPlacesWithTicketTypesPrompt', callback); Native.onPlacesWithTicketTypesPrompt(JSON.stringify(params)) }");
        }

        if (onTicketTypePrompt != null) {
            callbacks.add("onTicketTypePrompt: (params, callback) => { registerInternalCallback('onTicketTypePrompt', callback); Native.onTicketTypePrompt(JSON.stringify(params)) }");
        }

        return callbacks;
    }

    @Override
    protected String addAdditionalProperties(String configAsJson) {
        if (this.pricing == null || this.pricing.priceFormatter == null) {
            return configAsJson;
        }

        int insertionPoint = configAsJson.indexOf("\"pricing\":{") + "\"pricing\":{".length();
        StringBuilder sb = new StringBuilder(configAsJson.substring(0, insertionPoint));
        sb.append("priceFormatter: (price) => Native.formatPrice(price)");
        if (configAsJson.charAt(insertionPoint + 1) != '}') {
            sb.append(",");
        }
        sb.append(configAsJson.substring(insertionPoint));
        return sb.toString();
    }
}
