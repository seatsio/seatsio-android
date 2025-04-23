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
import java.util.function.Consumer;
import java.util.function.Function;

import io.seats.CommonConfig;
import io.seats.utils.Either;
import io.seats.utils.Function3;
import io.seats.utils.Function4;

public class SeatingChartConfig extends CommonConfig<SeatingChartConfig, SeatingChartView> {

    @Expose
    public String _client = "android";

    @Expose
    public String workspaceKey;

    @Expose
    public List<PricingForCategory> pricing;

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

    public Either<String, Function4<SeatsioObject, Boolean, Map<String, ?>, TicketTypePricing, Boolean>> canGASelectionBeIncreased;

    public String isObjectVisibleJavascriptFunction;
    public String objectLabelJavascriptFunction;
    public String objectIconJavascriptFunction;
    public Either<String, Function3<Section, String, Map<String, ?>, String>> sectionColor;

    public Either<String, BiConsumer<List<SeatsioObject>, Boolean>> onBestAvailableSelected;
    public Either<String, BiConsumer<List<SeatsioObject>, List<TicketType>>> onHoldSucceeded;
    public Either<String, BiConsumer<List<SeatsioObject>, List<TicketType>>> onHoldFailed;
    public Either<String, BiConsumer<List<SeatsioObject>, List<TicketType>>> onReleaseHoldSucceeded;
    public Either<String, BiConsumer<List<SeatsioObject>, List<TicketType>>> onReleaseHoldFailed;
    public Either<String, Runnable> onBestAvailableSelectionFailed;
    public Either<String, Runnable> onSelectionValid;
    public Either<String, Consumer<List<SelectionValidatorType>>> onSelectionInvalid;
    public Either<String, Runnable> onHoldCallsInProgress;
    public Either<String, Runnable> onHoldCallsComplete;
    public Either<String, Consumer<SeatsioObject>> onSelectedObjectBooked;
    public Either<String, Consumer<SeatsioObject>> onObjectStatusChanged;
    public Either<String, Consumer<HoldToken>> onSessionInitialized;
    public Either<String, Consumer<List<Category>>> onFilteredCategoriesChanged;
    public Either<String, Consumer<Floor>> onFloorChanged;
    public Either<String, Runnable> onHoldTokenExpired;
    public Function<Float, String> priceFormatter;
    public Either<String, BiConsumer<PromptsApiParams.OnPlacesPromptParams, Consumer<Integer>>> onPlacesPrompt;
    public Either<String, BiConsumer<PromptsApiParams.OnPlacesWithTicketTypesPromptParams, Consumer<Map<String, Integer>>>> onPlacesWithTicketTypesPrompt;
    public Either<String, BiConsumer<PromptsApiParams.OnTicketTypePromptParams, Consumer<String>>> onTicketTypePrompt;

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
        this.onBestAvailableSelected = Either.right(onBestAvailableSelected);
        return this;
    }

    public SeatingChartConfig setOnBestAvailableSelected(String onBestAvailableSelected) {
        this.onBestAvailableSelected = Either.left(onBestAvailableSelected);
        return this;
    }

    public SeatingChartConfig setOnBestAvailableSelectionFailed(Runnable onBestAvailableSelectionFailed) {
        this.onBestAvailableSelectionFailed = Either.right(onBestAvailableSelectionFailed);
        return this;
    }

    public SeatingChartConfig setOnBestAvailableSelectionFailed(String onBestAvailableSelectionFailed) {
        this.onBestAvailableSelectionFailed = Either.left(onBestAvailableSelectionFailed);
        return this;
    }

    public SeatingChartConfig setOnHoldSucceeded(BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldSucceeded) {
        this.onHoldSucceeded = Either.right(onHoldSucceeded);
        return this;
    }

    public SeatingChartConfig setOnHoldSucceeded(String onHoldSucceeded) {
        this.onHoldSucceeded = Either.left(onHoldSucceeded);
        return this;
    }

    public SeatingChartConfig setOnHoldFailed(BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldFailed) {
        this.onHoldFailed = Either.right(onHoldFailed);
        return this;
    }

    public SeatingChartConfig setOnHoldFailed(String onHoldFailed) {
        this.onHoldFailed = Either.left(onHoldFailed);
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldSucceeded(BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldSucceeded) {
        this.onReleaseHoldSucceeded = Either.right(onReleaseHoldSucceeded);
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldSucceeded(String onReleaseHoldSucceeded) {
        this.onReleaseHoldSucceeded = Either.left(onReleaseHoldSucceeded);
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldFailed(BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldFailed) {
        this.onReleaseHoldFailed = Either.right(onReleaseHoldFailed);
        return this;
    }

    public SeatingChartConfig setOnReleaseHoldFailed(String onReleaseHoldFailed) {
        this.onReleaseHoldFailed = Either.left(onReleaseHoldFailed);
        return this;
    }

    public SeatingChartConfig setOnSelectionValid(Runnable onSelectionValid) {
        this.onSelectionValid = Either.right(onSelectionValid);
        return this;
    }

    public SeatingChartConfig setOnSelectionValid(String onSelectionValid) {
        this.onSelectionValid = Either.left(onSelectionValid);
        return this;
    }

    public SeatingChartConfig setOnSelectionInvalid(Consumer<List<SelectionValidatorType>> onSelectionInvalid) {
        this.onSelectionInvalid = Either.right(onSelectionInvalid);
        return this;
    }

    public SeatingChartConfig setOnSelectionInvalid(String onSelectionInvalid) {
        this.onSelectionInvalid = Either.left(onSelectionInvalid);
        return this;
    }

    public SeatingChartConfig setOnHoldCallsInProgress(Runnable onHoldCallsInProgress) {
        this.onHoldCallsInProgress = Either.right(onHoldCallsInProgress);
        return this;
    }

    public SeatingChartConfig setOnHoldCallsInProgress(String onHoldCallsInProgress) {
        this.onHoldCallsInProgress = Either.left(onHoldCallsInProgress);
        return this;
    }

    public SeatingChartConfig setOnHoldCallsComplete(Runnable onHoldCallsComplete) {
        this.onHoldCallsComplete = Either.right(onHoldCallsComplete);
        return this;
    }

    public SeatingChartConfig setOnHoldCallsComplete(String onHoldCallsComplete) {
        this.onHoldCallsComplete = Either.left(onHoldCallsComplete);
        return this;
    }

    public SeatingChartConfig setOnSelectedObjectBooked(Consumer<SeatsioObject> onSelectedObjectBooked) {
        this.onSelectedObjectBooked = Either.right(onSelectedObjectBooked);
        return this;
    }

    public SeatingChartConfig setOnSelectedObjectBooked(String onSelectedObjectBooked) {
        this.onSelectedObjectBooked = Either.left(onSelectedObjectBooked);
        return this;
    }

    public SeatingChartConfig setOnObjectStatusChanged(Consumer<SeatsioObject> onObjectStatusChanged) {
        this.onObjectStatusChanged = Either.right(onObjectStatusChanged);
        return this;
    }

    public SeatingChartConfig setOnObjectStatusChanged(String onObjectStatusChanged) {
        this.onObjectStatusChanged = Either.left(onObjectStatusChanged);
        return this;
    }

    public SeatingChartConfig setOnSessionInitialized(Consumer<HoldToken> onSessionInitialized) {
        this.onSessionInitialized = Either.right(onSessionInitialized);
        return this;
    }

    public SeatingChartConfig setOnSessionInitialized(String onSessionInitialized) {
        this.onSessionInitialized = Either.left(onSessionInitialized);
        return this;
    }

    public SeatingChartConfig setOnHoldTokenExpired(Runnable onHoldTokenExpired) {
        this.onHoldTokenExpired = Either.right(onHoldTokenExpired);
        return this;
    }

    public SeatingChartConfig setOnHoldTokenExpired(String onHoldTokenExpired) {
        this.onHoldTokenExpired = Either.left(onHoldTokenExpired);
        return this;
    }

    public SeatingChartConfig setOnFilteredCategoriesChanged(Consumer<List<Category>> onFilteredCategoriesChanged) {
        this.onFilteredCategoriesChanged = Either.right(onFilteredCategoriesChanged);
        return this;
    }

    public SeatingChartConfig setOnFilteredCategoriesChanged(String onFilteredCategoriesChanged) {
        this.onFilteredCategoriesChanged = Either.left(onFilteredCategoriesChanged);
        return this;
    }

    public SeatingChartConfig setOnFloorChanged(Consumer<Floor> onFloorChanged) {
        this.onFloorChanged = Either.right(onFloorChanged);
        return this;
    }

    public SeatingChartConfig setOnFloorChanged(String onFloorChanged) {
        this.onFloorChanged = Either.left(onFloorChanged);
        return this;
    }

    public SeatingChartConfig setPriceFormatter(Function<Float, String> priceFormatter) {
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

    public SeatingChartConfig setObjectLabelJavascriptFunction(String objectLabelJavascriptFunction) {
        this.objectLabelJavascriptFunction = objectLabelJavascriptFunction;
        return this;
    }

    public SeatingChartConfig setObjectIconJavascriptFunction(String objectIconJavascriptFunction) {
        this.objectIconJavascriptFunction = objectIconJavascriptFunction;
        return this;
    }

    public SeatingChartConfig setIsObjectVisibleJavascriptFunction(String isObjectVisibleJavascriptFunction) {
        this.isObjectVisibleJavascriptFunction = isObjectVisibleJavascriptFunction;
        return this;
    }

    public SeatingChartConfig setCanGASelectionBeIncreased(Function4<SeatsioObject, Boolean, Map<String, ?>, TicketTypePricing, Boolean> canGASelectionBeIncreased) {
        this.canGASelectionBeIncreased = Either.right(canGASelectionBeIncreased);
        return this;
    }

    public SeatingChartConfig setCanGASelectionBeIncreased(String canGASelectionBeIncreased) {
        this.canGASelectionBeIncreased = Either.left(canGASelectionBeIncreased);
        return this;
    }

    public SeatingChartConfig setSectionColor(Function3<Section, String, Map<String, ?>, String> sectionColor) {
        this.sectionColor = Either.right(sectionColor);
        return this;
    }

    public SeatingChartConfig setSectionColor(String sectionColor) {
        this.sectionColor = Either.left(sectionColor);
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
        this.onPlacesPrompt = Either.right(onPlacesPrompt);
        return this;
    }

    public SeatingChartConfig setOnPlacesPrompt(String onPlacesPrompt) {
        this.onPlacesPrompt = Either.left(onPlacesPrompt);
        return this;
    }

    public SeatingChartConfig setOnPlacesWithTicketTypesPrompt(BiConsumer<PromptsApiParams.OnPlacesWithTicketTypesPromptParams, Consumer<Map<String, Integer>>> onPlacesWithTicketTypesPrompt) {
        this.onPlacesWithTicketTypesPrompt = Either.right(onPlacesWithTicketTypesPrompt);
        return this;
    }

    public SeatingChartConfig setOnPlacesWithTicketTypesPrompt(String onPlacesWithTicketTypesPrompt) {
        this.onPlacesWithTicketTypesPrompt = Either.left(onPlacesWithTicketTypesPrompt);
        return this;
    }

    public SeatingChartConfig setOnTicketTypePrompt(BiConsumer<PromptsApiParams.OnTicketTypePromptParams, Consumer<String>> onTicketTypePrompt) {
        this.onTicketTypePrompt = Either.right(onTicketTypePrompt);
        return this;
    }

    public SeatingChartConfig setOnTicketTypePrompt(String onTicketTypePrompt) {
        this.onTicketTypePrompt = Either.left(onTicketTypePrompt);
        return this;
    }

    @Override
    protected List<String> callbacks() {
        List<String> callbacks = super.callbacks();

        if (onBestAvailableSelected != null) {
            onBestAvailableSelected.forEach(
                    value -> callbacks.add("onBestAvailableSelected: " + value),
                    value -> callbacks.add("onBestAvailableSelected: (objects, nextToEachOther) => Native.onBestAvailableSelected(JSON.stringify(objects), nextToEachOther)")
            );
        }

        if (onBestAvailableSelectionFailed != null) {
            onBestAvailableSelectionFailed.forEach(
                    value -> callbacks.add("onBestAvailableSelectionFailed: " + value),
                    value -> callbacks.add("onBestAvailableSelectionFailed: () => Native.onBestAvailableSelectionFailed()")
            );
        }

        if (onSessionInitialized != null) {
            onSessionInitialized.forEach(
                    value -> callbacks.add("onSessionInitialized: " + value),
                    value -> callbacks.add("onSessionInitialized: (holdToken) => Native.onSessionInitialized(JSON.stringify(holdToken))")
            );
        }

        if (onHoldTokenExpired != null) {
            onHoldTokenExpired.forEach(
                    value -> callbacks.add("onHoldTokenExpired: " + value),
                    value -> callbacks.add("onHoldTokenExpired: () => Native.onHoldTokenExpired()")
            );
        }

        if (onHoldSucceeded != null) {
            onHoldSucceeded.forEach(
                    value -> callbacks.add("onHoldSucceeded: " + value),
                    value -> callbacks.add("onHoldSucceeded: (objects, ticketTypes) => Native.onHoldSucceeded(JSON.stringify(objects), JSON.stringify(ticketTypes))")
            );
        }

        if (onHoldFailed != null) {
            onHoldFailed.forEach(
                    value -> callbacks.add("onHoldFailed: " + value),
                    value -> callbacks.add("onHoldFailed: (objects, ticketTypes) => Native.onHoldFailed(JSON.stringify(objects), JSON.stringify(ticketTypes))")
            );
        }

        if (onReleaseHoldSucceeded != null) {
            onReleaseHoldSucceeded.forEach(
                    value -> callbacks.add("onReleaseHoldSucceeded: " + value),
                    value -> callbacks.add("onReleaseHoldSucceeded: (objects, ticketTypes) => Native.onReleaseHoldSucceeded(JSON.stringify(objects), JSON.stringify(ticketTypes))")
            );
        }

        if (onReleaseHoldFailed != null) {
            onReleaseHoldFailed.forEach(
                    value -> callbacks.add("onReleaseHoldFailed: " + value),
                    value -> callbacks.add("onReleaseHoldFailed: (objects, ticketTypes) => Native.onReleaseHoldFailed(JSON.stringify(objects), JSON.stringify(ticketTypes))")
            );
        }

        if (onSelectionValid != null) {
            onSelectionValid.forEach(
                    value -> callbacks.add("onSelectionValid: " + value),
                    value -> callbacks.add("onSelectionValid: () => Native.onSelectionValid()")
            );
        }

        if (onSelectionInvalid != null) {
            onSelectionInvalid.forEach(
                    value -> callbacks.add("onSelectionInvalid: " + value),
                    value -> callbacks.add("onSelectionInvalid: (violations) => Native.onSelectionInvalid(JSON.stringify(violations))")
            );
        }

        if (onHoldCallsInProgress != null) {
            onHoldCallsInProgress.forEach(
                    value -> callbacks.add("onHoldCallsInProgress: " + value),
                    value -> callbacks.add("onHoldCallsInProgress: () => Native.onHoldCallsInProgress()")
            );
        }

        if (onHoldCallsComplete != null) {
            onHoldCallsComplete.forEach(
                    value -> callbacks.add("onHoldCallsComplete: " + value),
                    value -> callbacks.add("onHoldCallsComplete: () => Native.onHoldCallsComplete()")
            );
        }

        if (onSelectedObjectBooked != null) {
            onSelectedObjectBooked.forEach(
                    value -> callbacks.add("onSelectedObjectBooked: " + value),
                    value -> callbacks.add("onSelectedObjectBooked: (object) => Native.onSelectedObjectBooked(JSON.stringify(object))")
            );
        }

        if (onObjectStatusChanged != null) {
            onObjectStatusChanged.forEach(
                    value -> callbacks.add("onObjectStatusChanged: " + value),
                    value -> callbacks.add("onObjectStatusChanged: (object) => Native.onObjectStatusChanged(JSON.stringify(object))")
            );
        }

        if (onFilteredCategoriesChanged != null) {
            onFilteredCategoriesChanged.forEach(
                    value -> callbacks.add("onFilteredCategoriesChanged: " + value),
                    value -> callbacks.add("onFilteredCategoriesChanged: (categories) => Native.onFilteredCategoriesChanged(JSON.stringify(categories))")
            );
        }

        if (onFloorChanged != null) {
            onFloorChanged.forEach(
                    value -> callbacks.add("onFloorChanged: " + value),
                    value -> callbacks.add("onFloorChanged: (floor) => Native.onFloorChanged(JSON.stringify(floor))")
            );
        }

        if (priceFormatter != null) {
            callbacks.add("priceFormatter: (price) => Native.formatPrice(price)");
        }

        if (objectLabelJavascriptFunction != null) {
            callbacks.add("objectLabel: " + objectLabelJavascriptFunction);
        }

        if (objectIconJavascriptFunction != null) {
            callbacks.add("objectIcon: " + objectIconJavascriptFunction);
        }

        if (isObjectVisibleJavascriptFunction != null) {
            callbacks.add("isObjectVisible: " + isObjectVisibleJavascriptFunction);
        }

        if (canGASelectionBeIncreased != null) {
            canGASelectionBeIncreased.forEach(
                    value -> callbacks.add("canGASelectionBeIncreased: " + value),
                    value -> callbacks.add("canGASelectionBeIncreased: (gaArea, defaultValue, extraConfig, ticketType) => Native.x(JSON.stringify(object), defaultValue, extraConfig, ticketType)")
            );
        }

        if (sectionColor != null) {
            sectionColor.forEach(
                    value -> callbacks.add("sectionColor: " + value),
                    value -> callbacks.add("sectionColor: (section, defaultColor, extraConfig) => Native.sectionColor(JSON.stringify(section), defaultColor, extraConfig)")
            );
        }

        if (onPlacesPrompt != null) {
            onPlacesPrompt.forEach(
                    value -> callbacks.add("onPlacesPrompt: " + value),
                    value -> callbacks.add("onPlacesPrompt: (params, callback) => { registerInternalCallback('onPlacesPrompt', callback); Native.onPlacesPrompt(JSON.stringify(params)) }")
            );
        }

        if (onPlacesWithTicketTypesPrompt != null) {
            onPlacesWithTicketTypesPrompt.forEach(
                    value -> callbacks.add("onPlacesWithTicketTypesPrompt: " + value),
                    value -> callbacks.add("onPlacesWithTicketTypesPrompt: (params, callback) => { registerInternalCallback('onPlacesWithTicketTypesPrompt', callback); Native.onPlacesWithTicketTypesPrompt(JSON.stringify(params)) }")
            );
        }

        if (onTicketTypePrompt != null) {
            onTicketTypePrompt.forEach(
                    value -> callbacks.add("onTicketTypePrompt: " + value),
                    value -> callbacks.add("onTicketTypePrompt: (params, callback) => { registerInternalCallback('onTicketTypePrompt', callback); Native.onTicketTypePrompt(JSON.stringify(params)) }")
            );
        }

        return callbacks;
    }
}
