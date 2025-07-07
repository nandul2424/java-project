package com.bluelanka_guide.controller.DestinationsPage;

import java.util.ArrayList;
import java.util.List;

public class DestinationManager {
    private List<DestinationsController.Destination> destinationsList;

    public DestinationManager() {
         destinationsList = new ArrayList<>();
         addDestination(new DestinationsController.Destination(1, "Negombo", "Sri Lanka",
                 "Browns Beach in Negombo is a popular coastal destination known for its golden sands, clear waters, and vibrant atmosphere. Famous for its fishing industry and lagoon.",
                 4.8, "/assets/images/destinations/Negombo.jpg", 7.2083, 79.8358, "Western Province",
                 "Swimming, Fishing, Boat Tours, Water Sports", "November to April"));
         addDestination(new DestinationsController.Destination(2, "Mount Lavinia", "Sri Lanka",
                 "A beautiful golden sandy beach just south of Colombo, perfect for sunset viewing and romantic walks. Popular among locals and tourists alike.",
                 4.6, "/assets/images/destinations/Mountlavinia.jpeg", 6.8344, 79.8633, "Western Province",
                 "Swimming, Sunset Viewing, Dining, Beach Walks", "December to March"));
         addDestination(new DestinationsController.Destination(3, "Kalutara", "Sri Lanka",
                 "Known for its wide sandy beaches and the famous Kalutara Bodhiya temple. Great for water sports and river activities on the Kalu Ganga.",
                 4.4, "/assets/images/destinations/Kaluthara.jpeg", 6.5854, 79.9607, "Western Province",
                 "Water Sports, Temple Visits, River Cruises", "November to April"));
         addDestination(new DestinationsController.Destination(4, "Hikkaduwa", "Sri Lanka",
                 "A bustling beach town known for its coral reefs, surfing, and vibrant nightlife. Perfect for snorkeling and diving enthusiasts.",
                 4.7, "/assets/images/destinations/hikkaduwa.jpg", 6.1395, 80.1063, "Southern Province",
                 "Surfing, Snorkeling, Diving, Nightlife", "November to April"));
         addDestination(new DestinationsController.Destination(5, "Unawatuna", "Sri Lanka",
                 "A crescent-shaped bay with calm waters, perfect for swimming and relaxation. One of the most beautiful beaches in Sri Lanka.",
                 4.8, "/assets/images/destinations/unawatuna.jpeg", 6.0108, 80.2492, "Southern Province",
                 "Swimming, Snorkeling, Beach Relaxation, Yoga", "December to March"));
         addDestination(new DestinationsController.Destination(6, "Mirissa", "Sri Lanka",
                 "Famous for whale watching and stunning sunsets. A laid-back beach town with excellent seafood and coconut tree-lined shores.",
                 4.9, "/assets/images/destinations/mirissa.jpg", 5.9487, 80.4565, "Southern Province",
                 "Whale Watching, Surfing, Sunset Viewing, Fishing", "December to April"));
         addDestination(new DestinationsController.Destination(7, "Weligama", "Sri Lanka",
                 "Known for its stilt fishermen and excellent surfing conditions. Features a beautiful bay with Snake Island accessible by foot during low tide.",
                 4.5, "/assets/images/destinations/weligama.jpeg", 5.9749, 80.4293, "Southern Province",
                 "Surfing, Stilt Fishing, Photography, Swimming", "November to April"));
         addDestination(new DestinationsController.Destination(8, "Tangalle", "Sri Lanka",
                 "A peaceful fishing town with pristine beaches and minimal crowds. Perfect for those seeking tranquility and natural beauty.",
                 4.6, "/assets/images/destinations/tangalle.jpeg", 6.0235, 80.7928, "Southern Province",
                 "Beach Relaxation, Turtle Watching, Fishing, Photography", "December to March"));
         addDestination(new DestinationsController.Destination(9, "Matara", "Sri Lanka",
                 "Historic coastal city with beautiful beaches and the famous Matara Fort. Great combination of culture and beach activities.",
                 4.3, "/assets/images/destinations/matara.jpeg", 5.9549, 80.5550, "Southern Province",
                 "Historical Tours, Beach Activities, Temple Visits", "December to March"));
         addDestination(new DestinationsController.Destination(10, "Koggala", "Sri Lanka",
                 "Home to a large lagoon and beautiful beaches. Famous for its stilt fishermen and the Martin Wickramasinghe Folk Museum.",
                 4.4, "/assets/images/destinations/koggala.jpeg", 5.9942, 80.3275, "Southern Province",
                 "Lagoon Tours, Cultural Visits, Stilt Fishing, Bird Watching", "December to March"));
         addDestination(new DestinationsController.Destination(11, "Arugam Bay", "Sri Lanka",
                 "World-renowned surfing destination with consistent waves and a laid-back atmosphere. Popular among international surfers.",
                 4.9, "/assets/images/destinations/arugambay.jpeg", 6.8404, 81.8368, "Eastern Province",
                 "Surfing, Beach Relaxation, Lagoon Safari, Yoga", "April to September"));
         addDestination(new DestinationsController.Destination(12, "Batticaloa", "Sri Lanka",
                 "Known for its singing fish phenomenon and beautiful lagoons. Rich in Tamil culture and history.",
                 4.2, "/assets/images/destinations/batticalo.jpeg", 7.7102, 81.6924, "Eastern Province",
                 "Lagoon Tours, Cultural Experiences, Fishing, Bird Watching", "April to September"));
         addDestination(new DestinationsController.Destination(13, "Trincomalee", "Sri Lanka",
                 "Features some of the finest natural harbors in the world and pristine beaches. Rich in naval history and marine life.",
                 4.7, "/assets/images/destinations/thrinco.jpeg", 8.5874, 81.2152, "Eastern Province",
                 "Whale Watching, Diving, Historical Tours, Beach Activities", "April to September"));
         addDestination(new DestinationsController.Destination(14, "Nilaveli", "Sri Lanka",
                 "Crystal clear waters and white sandy beaches near Trincomalee. Perfect for snorkeling and diving with coral reefs nearby.",
                 4.8, "/assets/images/destinations/nilaweli.jpeg", 8.6833, 81.1833, "Eastern Province",
                 "Snorkeling, Diving, Beach Relaxation, Boat Tours", "April to September"));
         addDestination(new DestinationsController.Destination(15, "Uppuveli", "Sri Lanka",
                 "A quieter alternative to Nilaveli with beautiful beaches and clear waters. Great for peaceful beach holidays.",
                 4.5, "/assets/images/destinations/uppuweli.jpg", 8.6167, 81.2167, "Eastern Province",
                 "Swimming, Beach Walks, Relaxation, Photography", "April to September"));
         addDestination(new DestinationsController.Destination(16, "Pasikudah", "Sri Lanka",
                 "Known for its shallow, calm waters extending far into the sea. Perfect for families with children and non-swimmers.",
                 4.6, "/assets/images/destinations/pasikuda.jpeg", 7.9333, 81.5500, "Eastern Province",
                 "Family Swimming, Water Sports, Beach Games, Relaxation", "April to September"));
         addDestination(new DestinationsController.Destination(17, "Kalkudah", "Sri Lanka",
                 "Adjacent to Pasikudah, offering similar calm waters and beautiful coral reefs. Less crowded and more pristine.",
                 4.5, "/assets/images/destinations/kalkuda.jpeg", 7.9167, 81.5333, "Eastern Province",
                 "Snorkeling, Swimming, Coral Viewing, Beach Relaxation", "April to September"));
         addDestination(new DestinationsController.Destination(18, "Jaffna Peninsula", "Sri Lanka",
                 "Unique cultural experience with beautiful beaches and rich Tamil heritage. Features pristine islands and lagoons.",
                 4.3, "/assets/images/destinations/jaffnapenis.jpg", 9.6615, 80.0255, "Northern Province",
                 "Cultural Tours, Island Hopping, Historical Sites, Fishing", "December to March"));
         addDestination(new DestinationsController.Destination(19, "Casuarina Beach", "Sri Lanka",
                 "Located in Karainagar, known for its casuarina trees and golden sand. A peaceful retreat in the northern region.",
                 4.4, "/assets/images/destinations/casuarina.jpeg", 9.7667, 79.9167, "Northern Province",
                 "Beach Relaxation, Photography, Swimming, Nature Walks", "December to March"));
         addDestination(new DestinationsController.Destination(20, "Kalpitiya", "Sri Lanka",
                 "Famous for dolphin watching and kite surfing. Features a long stretch of pristine beaches and lagoons.",
                 4.7, "/assets/images/destinations/kalpitiya.jpeg", 8.2333, 79.7667, "North Western Province",
                 "Dolphin Watching, Kite Surfing, Snorkeling, Lagoon Tours", "November to April"));
         addDestination(new DestinationsController.Destination(21, "Chilaw", "Sri Lanka",
                 "Known for its fishing industry and beautiful beaches. Features the famous Munneswaram Temple nearby.",
                 4.2, "/assets/images/destinations/chilaw.jpeg", 7.5756, 79.7951, "North Western Province",
                 "Fishing, Temple Visits, Beach Activities, Cultural Tours", "November to April"));
         addDestination(new DestinationsController.Destination(22, "Benthota", "Sri Lanka",
                 "Popular resort town with water sports and river activities. Perfect blend of beach and river experiences.",
                 4.6, "/assets/images/destinations/bentota.jpeg", 6.4167, 79.9958, "Southern Province",
                 "Water Sports, River Safari, Turtle Hatchery, Spa Treatments", "November to April"));
         addDestination(new DestinationsController.Destination(23, "Beruwala", "Sri Lanka",
                 "One of the first beach resorts in Sri Lanka with a rich Muslim heritage. Features beautiful mosques and beaches.",
                 4.3, "/assets/images/destinations/beruwala.jpeg", 6.4792, 79.9828, "Western Province",
                 "Cultural Tours, Beach Activities, Mosque Visits, Water Sports", "November to April"));
         addDestination(new DestinationsController.Destination(24, "Ahungalla", "Sri Lanka",
                 "Quiet beach destination perfect for relaxation and turtle watching. Less commercialized than neighboring beaches.",
                 4.4, "/assets/images/destinations/ahungalla.jpg", 6.3167, 80.0833, "Southern Province",
                 "Turtle Watching, Beach Relaxation, Spa Treatments, Swimming", "November to April"));
         addDestination(new DestinationsController.Destination(25, "Dikwella", "Sri Lanka",
                 "Features the famous Wewurukannala Vihara temple and beautiful beaches. Great for cultural and beach experiences.",
                 4.3, "/assets/images/destinations/dikwella.jpeg", 5.9667, 80.7000, "Southern Province",
                 "Temple Visits, Beach Activities, Photography, Cultural Tours", "December to March"));
    }

    public List<DestinationsController.Destination> getDestinationsList() {
        return destinationsList;
    }

    public DestinationsController.Destination getSelectedDestination(int currentIndex){
        return destinationsList.get(currentIndex);
    }

    public void setDestinationsList(List<DestinationsController.Destination> destinationsList) {
        this.destinationsList = destinationsList;
    }

    public void addDestination(DestinationsController.Destination destination) {
        this.destinationsList.add(destination);
    }

    public void removeDestination(DestinationsController.Destination destination) {
        this.destinationsList.remove(destination);
    }

    public void AddAllDestinations(List<DestinationsController.Destination> destinations) {
        this.destinationsList.addAll(destinations);
    }
}
