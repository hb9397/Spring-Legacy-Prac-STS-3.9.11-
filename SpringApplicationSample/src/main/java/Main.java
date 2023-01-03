import persistence.ItemRepository;
import domain.Item;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ItemRepository itemRepository = new ItemRepository();
		
		Item item = itemRepository.get();
		System.out.println(item);
	}

}
