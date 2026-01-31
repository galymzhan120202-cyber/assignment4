import repository.BookRepository;
import repository.BookRepositoryImpl;
import service.BookService;
import controller.LibraryController;

public class Main {
    public static void main(String[] args) {
        try {

            BookRepository repository = new BookRepositoryImpl();

            BookService service = new BookService(repository);

            LibraryController controller = new LibraryController(service);

            System.out.println("Starting Library Application...");
            controller.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}