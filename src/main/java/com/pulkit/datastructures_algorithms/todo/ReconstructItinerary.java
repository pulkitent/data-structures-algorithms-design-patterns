import java.util.*;

/*

["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]

["JFK" -> "ATL","SFO"]
["SFO" -> "ATL"]
["ATL" -> "JFK","SFO"]

[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]

["JFK" -> "MUC"]
["MUC" -> "LHR"]
["LHR", "SFO"]
["SFO" -> "SJC"]

[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]

["JFK" -> "KUL","NRT"]
["NRT","JFK"]

 */

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new LinkedList<>();

        LinkedList<String> l1 = new LinkedList<>();
        l1.add("JFK");
        l1.add("KUL");
        tickets.add(l1);

        LinkedList<String> l2 = new LinkedList<>();
        l2.add("JFK");
        l2.add("NRT");
        tickets.add(l2);

        LinkedList<String> l3 = new LinkedList<>();
        l3.add("NRT");
        l3.add("JFK");
        tickets.add(l3);

//        LinkedList<String> l1 = new LinkedList<>();
//        l1.add("JFK");
//        l1.add("ATL");
//        tickets.add(l1);
//
//        LinkedList<String> l2 = new LinkedList<>();
//        l2.add("SFO");
//        l2.add("ATL");
//        tickets.add(l2);
//
//        LinkedList<String> l3 = new LinkedList<>();
//        l3.add("ATL");
//        l3.add("JFK");
//        tickets.add(l3);
//
//        LinkedList<String> l4 = new LinkedList<>();
//        l4.add("ATL");
//        l4.add("SFO");
//        tickets.add(l4);
//
//        LinkedList<String> l5 = new LinkedList<>();
//        l5.add("JFK");
//        l5.add("SFO");
//        tickets.add(l5);

//        LinkedList<String> l1 = new LinkedList<>();
//        l1.add("JFK");
//        l1.add("MUC");
//        tickets.add(l1);
//
//        LinkedList<String> l2 = new LinkedList<>();
//        l2.add("MUC");
//        l2.add("LHR");
//        tickets.add(l2);
//
//        LinkedList<String> l3 = new LinkedList<>();
//        l3.add("LHR");
//        l3.add("SFO");
//        tickets.add(l3);
//
//        LinkedList<String> l4 = new LinkedList<>();
//        l4.add("SFO");
//        l4.add("SJC");
//        tickets.add(l4);


        List<String> result = findItinerary(tickets);

        for (String location : result) {
            System.out.print(location + " ");
        }
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> itinerary = new HashMap<>();
        List<String> uniqueTos = new LinkedList<>();
        List<String> sortedUniqueTos = new LinkedList<>();

        for (List<String> fromTo : tickets) {
            String from = fromTo.get(0);
            String to = fromTo.get(1);

            if (itinerary.containsKey(from)) {
                List<String> toList = itinerary.get(from);
                toList.add(to);
            } else {
                uniqueTos.add(from);
                sortedUniqueTos.add(from);
                LinkedList<String> toList = new LinkedList<>();
                toList.add(to);
                itinerary.put(from, toList);
            }
        }

        sortedUniqueTos.sort(new FormToComparator());

        Set<String> strings = itinerary.keySet();

        for (String from : strings) {
            List<String> toList = itinerary.get(from);
            toList.sort(new FormToComparator());
        }

        String start = "JFK";
        List<String> result = new LinkedList<>();
        result.add(start);

        while (itinerary.size() > 0) {
            removedEmptyFromKeys(itinerary, uniqueTos);
            List<String> toList = itinerary.get(start);

            if (toList != null && !toList.isEmpty()) {
                String e = toList.get(0);
                result.add(e);
                toList.remove(e);
                sortedUniqueTos.remove(e);
                start = e;
            } else {
                removedEmptyFromKeys(itinerary, uniqueTos);
                if (!sortedUniqueTos.isEmpty()) {
                    start = sortedUniqueTos.get(0);
                }
            }
        }

        return result;
    }

    private static void removedEmptyFromKeys(Map<String, List<String>> itinerary,
                                             List<String> uniqueTos) {
        for (String fromToBeRemoved : uniqueTos) {
            List<String> toList = itinerary.get(fromToBeRemoved);
            if (toList != null && toList.isEmpty()) {
                itinerary.remove(fromToBeRemoved);
            }
        }
    }
}

class FormToComparator implements Comparator<String> {
    @Override
    public int compare(String t1, String t2) {
        return t1.compareTo(t2);
    }
}
