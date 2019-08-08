package io.seats.seatingChart;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class SeatingChartConfig {

    @Expose
    public String publicKey;

    @Expose
    public Collection<String> events;

    @Expose
    private List<PricingForCategory> pricing;

    @Expose
    public Integer numberOfPlacesToSelect;

    @Expose
    public Boolean objectWithoutPricingSelectable;

    @Expose
    public Boolean objectWithoutCategorySelectable;

    @Expose
    public List<SelectedObject> selectedObjects;

    @Expose
    public ObjectTooltip objectTooltip;

    @Expose
    public ThemePreset themePreset;

    @Expose
    public ThemeColors themeColors;

    @Expose
    public String language;

    @Expose
    public Map<String, String> messages;

    @Expose
    public String priceLevelsTooltipMessage;

    @Expose
    public Object maxSelectedObjects;

    @Expose
    public List<String> unavailableCategories;

    @Expose
    public BestAvailable selectBestAvailable;

    @Expose
    public Boolean showRowLines;

    @Expose
    public Boolean alwaysShowSectionContents;

    @Expose
    public Boolean showLegend;

    @Expose
    public Legend legend;

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
    public Boolean holdOnSelect;

    @Expose
    public Boolean holdOnSelectForGAs;

    @Expose
    public String holdToken;

    @Expose
    public Boolean regenerateHoldToken;

    @Expose
    public String objectLabel;

    @Expose
    public String objectIcon;

    @Expose
    public String isObjectVisible;

    @Expose
    public String canGASelectionBeIncreased;

    @Expose
    public String objectColor;

    @Expose
    public String sectionColor;

    @Expose
    public Map<String, ?> extraConfig;

    public BiConsumer<SeatsioObject, TicketType> onObjectSelected;
    public BiConsumer<SeatsioObject, TicketType> onObjectDeselected;
    public Consumer<SeatsioObject> onObjectClicked;
    public BiConsumer<List<SeatsioObject>, Boolean> onBestAvailableSelected;
    public BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldSucceeded;
    public BiConsumer<List<SeatsioObject>, List<TicketType>> onHoldFailed;
    public BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldSucceeded;
    public BiConsumer<List<SeatsioObject>, List<TicketType>> onReleaseHoldFailed;
    public Runnable onBestAvailableSelectionFailed;
    public Runnable onSelectionValid;
    public Consumer<List<SelectionValidatorType>> onSelectionInvalid;
    public Consumer<SeatsioObject> onSelectedObjectBooked;
    public Function<SeatsioObject, String> tooltipInfo;
    public Consumer<SeatingChartView> onChartRendered;
    public Consumer<SeatingChartView> onChartRenderingFailed;
    public Function<Float, String> priceFormatter;

    @Expose
    public String _client = "android";

    public SeatingChartConfig setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public SeatingChartConfig setEvent(String event) {
        HashSet<String> events = new HashSet<>();
        events.add(event);
        this.events = events;
        return this;
    }

    public SeatingChartConfig setEvents(Collection<String> events) {
        this.events = events;
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

    public SeatingChartConfig setOnObjectSelected(BiConsumer<SeatsioObject, TicketType> onObjectSelected) {
        this.onObjectSelected = onObjectSelected;
        return this;
    }

    public SeatingChartConfig setOnObjectDeselected(BiConsumer<SeatsioObject, TicketType> onObjectDeselected) {
        this.onObjectDeselected = onObjectDeselected;
        return this;
    }

    public SeatingChartConfig setOnObjectClicked(Consumer<SeatsioObject> onObjectClicked) {
        this.onObjectClicked = onObjectClicked;
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

    public SeatingChartConfig setOnSelectedObjectBooked(Consumer<SeatsioObject> onSelectedObjectBooked) {
        this.onSelectedObjectBooked = onSelectedObjectBooked;
        return this;
    }

    public SeatingChartConfig setTooltipInfo(Function<SeatsioObject, String> tooltipInfo) {
        this.tooltipInfo = tooltipInfo;
        return this;
    }

    public SeatingChartConfig setOnChartRendered(Consumer<SeatingChartView> onChartRendered) {
        this.onChartRendered = onChartRendered;
        return this;
    }

    public SeatingChartConfig setOnChartRenderingFailed(Consumer<SeatingChartView> onChartRenderingFailed) {
        this.onChartRenderingFailed = onChartRenderingFailed;
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

    public SeatingChartConfig setObjectWithoutCategorySelectable(boolean objectWithoutCategorySelectable) {
        this.objectWithoutCategorySelectable = objectWithoutCategorySelectable;
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

    public SeatingChartConfig setLanguage(String language) {
        this.language = language;
        return this;
    }

    public SeatingChartConfig setMessages(Map<String, String> messages) {
        this.messages = messages;
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

    public SeatingChartConfig setUnavailableCategories(String... unavailableCategories) {
        this.unavailableCategories = asList(unavailableCategories);
        return this;
    }

    public SeatingChartConfig setSelectBestAvailable(BestAvailable selectBestAvailable) {
        this.selectBestAvailable = selectBestAvailable;
        return this;
    }

    public SeatingChartConfig setShowRowLines(boolean showRowLines) {
        this.showRowLines = showRowLines;
        return this;
    }

    public SeatingChartConfig setAlwaysShowSectionContents(boolean alwaysShowSectionContents) {
        this.alwaysShowSectionContents = alwaysShowSectionContents;
        return this;
    }

    public SeatingChartConfig setShowLegend(boolean showLegend) {
        this.showLegend = showLegend;
        return this;
    }

    public SeatingChartConfig setLegend(Legend legend) {
        this.legend = legend;
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

    public SeatingChartConfig setHoldOnSelect(boolean holdOnSelect) {
        this.holdOnSelect = holdOnSelect;
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

    public SeatingChartConfig setRegenerateHoldToken(boolean regenerateHoldToken) {
        this.regenerateHoldToken = regenerateHoldToken;
        return this;
    }

    public SeatingChartConfig setObjectLabel(String objectLabel) {
        this.objectLabel = objectLabel;
        return this;
    }

    public SeatingChartConfig setObjectIcon(String objectIcon) {
        this.objectIcon = objectIcon;
        return this;
    }

    public SeatingChartConfig setIsObjectVisible(String isObjectVisible) {
        this.isObjectVisible = isObjectVisible;
        return this;
    }

    public SeatingChartConfig setCanGASelectionBeIncreased(String canGASelectionBeIncreased) {
        this.canGASelectionBeIncreased = canGASelectionBeIncreased;
        return this;
    }

    public SeatingChartConfig setObjectColor(String objectColor) {
        this.objectColor = objectColor;
        return this;
    }

    public SeatingChartConfig setSectionColor(String sectionColor) {
        this.sectionColor = sectionColor;
        return this;
    }

    public SeatingChartConfig setExtraConfig(Map<String, ?> extraConfig) {
        this.extraConfig = extraConfig;
        return this;
    }

    public String toJson() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(PricingForCategory.class, new PricingForCategory.PricingForCategorySerializer())
                .create();

        String configAsJson = gson.toJson(this);
        String configAsJsonWithoutLastChar = configAsJson.substring(0, configAsJson.length() - 1);

        if (onObjectSelected != null) {
            configAsJsonWithoutLastChar += ", onObjectSelected: (object, ticketType) => Native.onObjectSelected(JSON.stringify(object), ticketType ? JSON.stringify(ticketType) : null)";
        }

        if (onObjectDeselected != null) {
            configAsJsonWithoutLastChar += ", onObjectDeselected: (object, ticketType) => Native.onObjectDeselected(JSON.stringify(object), ticketType ? JSON.stringify(ticketType) : null)";
        }

        if (onObjectClicked != null) {
            configAsJsonWithoutLastChar += ", onObjectClicked: object => Native.onObjectClicked(JSON.stringify(object))";
        }

        if (onBestAvailableSelected != null) {
            configAsJsonWithoutLastChar += ", onBestAvailableSelected: (objects, nextToEachOther) => Native.onBestAvailableSelected(JSON.stringify(objects), nextToEachOther)";
        }

        if (onBestAvailableSelectionFailed != null) {
            configAsJsonWithoutLastChar += ", onBestAvailableSelectionFailed: () => Native.onBestAvailableSelectionFailed()";
        }

        if (onHoldSucceeded != null) {
            configAsJsonWithoutLastChar += ", onHoldSucceeded: (objects, ticketTypes) => Native.onHoldSucceeded(JSON.stringify(objects), JSON.stringify(ticketTypes))";
        }

        if (onHoldFailed != null) {
            configAsJsonWithoutLastChar += ", onHoldFailed: (objects, ticketTypes) => Native.onHoldFailed(JSON.stringify(objects), JSON.stringify(ticketTypes))";
        }

        if (onReleaseHoldSucceeded != null) {
            configAsJsonWithoutLastChar += ", onReleaseHoldSucceeded: (objects, ticketTypes) => Native.onReleaseHoldSucceeded(JSON.stringify(objects), JSON.stringify(ticketTypes))";
        }

        if (onReleaseHoldFailed != null) {
            configAsJsonWithoutLastChar += ", onReleaseHoldFailed: (objects, ticketTypes) => Native.onReleaseHoldFailed(JSON.stringify(objects), JSON.stringify(ticketTypes))";
        }

        if (onSelectionValid != null) {
            configAsJsonWithoutLastChar += ", onSelectionValid: () => Native.onSelectionValid()";
        }

        if (onSelectionInvalid != null) {
            configAsJsonWithoutLastChar += ", onSelectionInvalid: (violations) => Native.onSelectionInvalid(JSON.stringify(violations))";
        }

        if (onSelectedObjectBooked != null) {
            configAsJsonWithoutLastChar += ", onSelectedObjectBooked: object => Native.onSelectedObjectBooked(JSON.stringify(object))";
        }

        if (tooltipInfo != null) {
            configAsJsonWithoutLastChar += ", tooltipInfo: object => Native.tooltipInfo(JSON.stringify(object))";
        }

        if (onChartRendered != null) {
            configAsJsonWithoutLastChar += ", onChartRendered: object => Native.onChartRendered()";
        }

        if (onChartRendered != null) {
            configAsJsonWithoutLastChar += ", onChartRenderingFailed: object => Native.onChartRenderingFailed()";
        }

        if (priceFormatter != null) {
            configAsJsonWithoutLastChar += ", priceFormatter: price => Native.formatPrice(price)";
        }

        if (objectLabel != null) {
            configAsJsonWithoutLastChar += ", objectLabel: " + objectLabel;
        }

        if (objectIcon != null) {
            configAsJsonWithoutLastChar += ", objectIcon: " + objectIcon;
        }

        if (isObjectVisible != null) {
            configAsJsonWithoutLastChar += ", isObjectVisible: " + isObjectVisible;
        }

        if (canGASelectionBeIncreased != null) {
            configAsJsonWithoutLastChar += ", canGASelectionBeIncreased: " + canGASelectionBeIncreased;
        }

        if (objectColor != null) {
            configAsJsonWithoutLastChar += ", objectColor: " + objectColor;
        }

        if (sectionColor != null) {
            configAsJsonWithoutLastChar += ", sectionColor: " + sectionColor;
        }

        configAsJson = configAsJsonWithoutLastChar + "}";
        return configAsJson;
    }

}
