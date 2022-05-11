public class Main {

    public static void main(String[] args) {

        ContactsBook book = new ContactsBook();

        book.add(new Contact("Максим", "88_005_553_535"));
        book.add(new Contact("Алексей", "88_444_444_444"));
        book.add(new Contact("Андрей", "88_444_613_333"));
        book.add(new Contact("Николай", "88_153_444_222"));
        book.add(new Contact("Сергей", "88_153_444_111"));
        book.add(new Contact("Алексей", "88_444_666_666"));


        Contact foundContact = book.getByPhone("88_005_553_535");
        System.out.println(foundContact);
        book.removeByPhone("88_444_444_444");
        System.out.println(book.returnContactsBook());

        System.out.println(book.searchBy(contact -> contact.getName().equals("Максим")));
        System.out.println(book.searchBy("Ан*ей"));
    }

}
