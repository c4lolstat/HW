package collection.interfaces;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.ClassicOnlineStore;
import common.test.tool.entity.Customer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise1Test extends ClassicOnlineStore {

    @Easy @Test
    public void iterateByForEach() {
        Iterable<Customer> customerIterable = this.mall.getCustomerList();
        List<String> nameList = new ArrayList<>();

        /**
         * Create a {@link Consumer} which represents an operation to add customer's name to {@link nameList} list.
         * Iterate {@link customerIterable} with {@link Iterable#forEach} and use the {@link Consumer}
         * to finish creating the name list.
         */
        customerIterable.forEach(customer -> nameList.add(customer.getName()));
        assertThat(nameList.toString(), is("[Joe, Steven, Patrick, Diana, Chris, Kathy, Alice, Andrew, Martin, Amy]"));
    }

    @Easy @Test
    public void whoHaveNoEInYourName() {
        Collection<String> nameCollection =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link Predicate} which predicates if the input string contains "e".
         * Remove elements from {@link nameCollection} which contains "e" using {@link Collection#removeIf}.
         */
        Predicate<Object> predicate = o -> {
            String test = (String) o;
            return !test.contains("e");
        };

        List<String> result = nameCollection.stream().filter(predicate::test).collect(Collectors.toList());
        // nameCollection.

        assertThat(result.toString(), is("[Patrick, Chris]"));
    }

    @Easy @Test
    public void replaceTheElements() {
        List<String> nameList =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link UnaryOperator} which returns given string wrapped with "()".
         * Replace the elements in {@link nameList} with string wrapped with "()" using {@link List#replaceAll} .
         */
        UnaryOperator<Object> unaryOperator = null;
        // nameList.

        List<String> result = nameList.stream().map(name -> "("+name+")").collect(Collectors.toList());

        assertThat(result.toString(), is("[(Joe), (Steven), (Patrick), (Chris)]"));
    }

    @Easy @Test
    public void sortByName() {
        List<String> nameList =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link Comparator} to sort the name list by their name's length in ascending order.
         */
        Comparator<Object> comparator = (o1, o2) -> {
            String test1 = (String) o1;
            String test2 = (String) o2;
            int result = 0;
            if (test1.length() < test2.length())
                result =  -1;
            if (test1.length() == test2.length())
                result = 0;
            if (test1.length() > test2.length())
                result = 1;
            return result;
        };
        // nameList.
        List<String> result = nameList.stream().sorted(comparator).collect(Collectors.toList());

        assertThat(result.toString(), is("[Joe, Chris, Steven, Patrick]"));
    }

    @Easy @Test
    public void createStream() {
        Collection<String> nameList =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a serial {@link Stream} using {@link Collection#stream}
         * You can learn about {@link Stream} APIs at stream-api module.
         */
        Stream<String> nameStream = nameList.stream();

        assertThat(nameStream.count(), is(4L));
        assertThat(nameStream.isParallel(), is(false));
    }

    @Easy @Test
    public void createParallelStream() {
        Collection<String> nameList =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a parallel {@link Stream} using {@link Collection#parallelStream} or {@link Stream#parallel}
         */
        Stream<String> nameParallelStream = nameList.parallelStream();

        assertThat(nameParallelStream.count(), is(4L));
        assertThat(nameParallelStream.isParallel(), is(true));
    }
}
