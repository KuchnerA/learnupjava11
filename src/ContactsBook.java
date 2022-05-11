import java.util.*;
import java.util.function.Predicate;

public class ContactsBook {

    Map<String, Contact> map = new HashMap<>();

    public void add(Contact contact) {
        map.put(contact.getPhone(), contact);
    }

    public Contact getByPhone(String phone) {

        if (map.containsKey(phone)) {
            return map.get(phone);
        }
        return null;
    }

    public void removeByPhone(String phone) {

        if (map.containsKey(phone)) {
            map.remove(phone);
            return;
        }
        throw new PhoneException(phone);
    }

    public List<Contact> returnContactsBook() {
        List<Contact> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }

    public List<Contact> searchBy(Predicate<Contact> criteria) {
        List<Contact> list1 = new ArrayList<>();
        for (Contact contact : map.values()) {
            if (criteria.test(contact)) {
                list1.add(contact);
            }
        }
        Collections.sort(list1);
        return list1;
    }

    public List<Contact> searchBy(String criteria) {

        if (criteria.contains("*")) {
            if (criteria.startsWith("*")) {
                return searchBy(contact -> contact.getName().endsWith(criteria.substring(1)));
            } else if (criteria.endsWith("*")) {
                return searchBy(contact -> contact.getName().startsWith(criteria.substring(0, criteria.length() - 1)));
            } else {
                int i = criteria.indexOf("*");
                return searchBy(contact -> contact.getName().startsWith(criteria.substring(0, i)) && contact.getName().endsWith(criteria.substring(i + 1)));
            }
        }
        return searchBy(contact -> contact.getName().equals(criteria));
    }
}

