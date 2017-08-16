package stream.api;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.ClassicOnlineStore;
import common.test.tool.entity.Customer;
import common.test.tool.entity.Item;
import common.test.tool.util.AssertUtil;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class Exercise2Test extends ClassicOnlineStore {

    @Easy @Test
    public void sortByAge() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a stream with ascending ordered age values.
         * Use {@link Stream#sorted} to sort them.
         */

        // nameList.
        List<Integer> result = customerList.stream().map(Customer::getAge).sorted().collect(Collectors.toList());

        assertThat(result, contains(21, 22, 22, 26, 27, 28, 32, 35, 36, 38));
    }

    @Easy @Test
    public void descSortByAge() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a stream with descending ordered age values.
         */
        Comparator<Integer> descOrder =  (o1, o2) -> {
            Integer test1 = (Integer) o1;
            Integer test2 = (Integer) o2;
            int result = 0;
            if (test1 < test2)
                result =  1;
            if (test1 == test2)
                result = 0;
            if (test1 > test2)
                result = -1;
            return result;
        };

        List<Integer> result = customerList.stream().map(Customer::getAge).sorted(descOrder).collect(Collectors.toList());

        assertTrue(AssertUtil.isLambda(descOrder));
        assertThat(result, contains(38, 36, 35, 32, 28, 27, 26, 22, 22, 21));
    }

    @Easy @Test
    public void top3RichCustomer() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a stream with top 3 rich customers using {@link Stream#limit} to limit the size of the stream
         */

        Comparator<Customer> order =  (o1, o2) -> {
            Customer test1 = (Customer) o1;
            Customer test2 = (Customer) o2;
            int result = 0;
            if (test1.getBudget() < test2.getBudget())
                result = 1;
            if (test1.getBudget() == test2.getBudget())
                result = 0;
            if (test1.getBudget() > test2.getBudget())
                result = -1;
            return result;
        };

        List<String> result = customerList.stream().sorted(order).limit(3).map(Customer::getName).collect(Collectors.toList());
        assertThat(result, contains("Diana", "Andrew", "Chris"));
    }

    @Easy @Test
    public void distinctAge() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a stream with distinct age values using {@link Stream#distinct}
         */

        List<Integer> result = customerList.stream().map(Customer::getAge).distinct(). collect(Collectors.toList());
        assertThat(result, contains(22, 27, 28, 38, 26, 32, 35, 21, 36));
    }

    @Easy @Test
    public void itemsCustomersWantToBuy() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a stream with items' names stored in {@link Customer.wantToBuy}
         * Use {@link Stream#flatMap} to create a stream from each element of a stream.
         */
        Function<Customer, Stream<Item>> getItemStream = c -> c.getWantToBuy().stream();
        Stream<String> itemStream = customerList.stream().flatMap(getItemStream).map(Item::getName);

        assertTrue(AssertUtil.isLambda(getItemStream));
        List<String> itemList = itemStream.collect(Collectors.toList());
        assertThat(itemList,
                   contains("small table", "plate", "fork", "ice cream", "screwdriver", "cable", "earphone", "onion",
                            "ice cream", "crisps", "chopsticks", "cable", "speaker", "headphone", "saw", "bond",
                            "plane", "bag", "cold medicine", "chair", "desk", "pants", "coat", "cup", "plate", "fork",
                            "spoon", "ointment", "poultice", "spinach", "ginseng", "onion"));
    }
}
