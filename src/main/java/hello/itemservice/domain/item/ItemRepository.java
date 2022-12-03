package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    /**
     static! MultiThread 환경 HashMap은 동시성 문제로 실제로는 사용하면 안돼!
     ConCurrentHashMap<>(); 사용!
     */

    private static long sequence = 0L;
    /**
    static long-> AtomicLong
     Thread-safe 로 구현되어 멀티쓰레드에서 synchronized 없이 사용할 수 있다.
     또한 synchronized 보다 적은 비용으로 동시성을 보장할 수 있습니다.
    */

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); // 안전하게 ArrayList 로 감싸서 반환.
    }

    public void update(Long itemId, Item updateParam) {

        // paramDto 를 만들어서 사용함. 필드가 4개인데 3개만 써서 하나가 남으니 혼란스러움.
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
