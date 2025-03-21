package io.seats.seatingChart;

import java.util.List;
import java.util.Map;

public class PromptsApiParams {

    private PromptsApiParams() {
    }

    public static class OnPlacesPromptParams {
        public final int selectedPlaces;
        public final int minPlaces;
        public final int maxPlaces;
        public final SeatsioObject objectToSelect;

        public OnPlacesPromptParams(int selectedPlaces, int minPlaces, int maxPlaces, SeatsioObject objectToSelect) {
            this.selectedPlaces = selectedPlaces;
            this.minPlaces = minPlaces;
            this.maxPlaces = maxPlaces;
            this.objectToSelect = objectToSelect;
        }
    }

    public static class OnPlacesWithTicketTypesPromptParams {
        public final List<TicketType> ticketTypes;
        public final Map<String, Integer> selectedPlacesByTicketType;
        public final int minPlaces;
        public final int maxPlaces;
        public final List<SeatsioObject> objectsToSelect;

        public OnPlacesWithTicketTypesPromptParams(List<TicketType> ticketTypes, Map<String, Integer> selectedPlacesByTicketType, int minPlaces, int maxPlaces, List<SeatsioObject> objectsToSelect) {
            this.ticketTypes = ticketTypes;
            this.selectedPlacesByTicketType = selectedPlacesByTicketType;
            this.minPlaces = minPlaces;
            this.maxPlaces = maxPlaces;
            this.objectsToSelect = objectsToSelect;
        }
    }

    public static class OnTicketTypePromptParams {
        public final List<TicketType> ticketTypes;
        public final SeatsioObject objectToSelect;

        public OnTicketTypePromptParams(List<TicketType> ticketTypes, SeatsioObject objectToSelect) {
            this.ticketTypes = ticketTypes;
            this.objectToSelect = objectToSelect;
        }
    }
}
