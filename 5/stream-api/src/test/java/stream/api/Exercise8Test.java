package stream.api;

import common.test.tool.annotation.Difficult;
import common.test.tool.dataset.ClassicOnlineStore;
import common.test.tool.entity.Customer;
import common.test.tool.entity.Item;
import common.test.tool.entity.Shop;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.*;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class Exercise8Test extends ClassicOnlineStore {

    @Difficult @Test
    public void itemsNotOnSale() {
        Stream<Customer> customerStream = this.mall.getCustomerList().stream();
        Stream<Shop> shopStream = this.mall.getShopList().stream();

        /**
         * Create a set of item names that are in {@link Customer.wantToBuy} but not on sale in any shop.
         */
        Function<Customer, Stream<Item>> getItemStream = c -> c.getWantToBuy().stream();
        Function<Shop, Stream<Item>> getShopItemStream = s -> s.getItemList().stream();

        List<String> itemListOnSale = shopStream.flatMap(getShopItemStream).map(Item::getName).collect(Collectors.toList());


        Predicate<String> listFilter = s -> !itemListOnSale.contains(s);
        Set<String> itemSetNotOnSale = customerStream.flatMap(getItemStream).map(Item::getName).filter(listFilter).collect(Collectors.toSet());

        assertThat(itemSetNotOnSale, hasSize(3));
        assertThat(itemSetNotOnSale, hasItems("bag", "pants", "coat"));
    }

    @Difficult @Test
    public void havingEnoughMoney() {
        Stream<Customer> customerStream = this.mall.getCustomerList().stream();
        Stream<Shop> shopStream = this.mall.getShopList().stream();

        /**
         * Create a customer's name list including who are having enough money to buy all items they want which is on sale.
         * Items that are not on sale can be counted as 0 money cost.
         * If there is several same items with different prices, customer can choose the cheapest one.
         */

        Function<Shop, Stream<Item>> getShopItemStream = s -> s.getItemList().stream();
        //This comparator stuff is black magic but wirking
        TreeSet<Item> onSale = shopStream.flatMap(getShopItemStream).collect(Collectors.toCollection(() -> new TreeSet<Item>(Comparator.comparingInt(Item::getPrice).reversed())));

        Predicate<Customer> havingEnoughMoney = c -> {
            List<String> customerGoods = c.getWantToBuy().stream().map(Item::getName).collect(Collectors.toList());
            IntStream prices = onSale.stream().filter(i -> customerGoods.contains(i.getName())).mapToInt(Item::getPrice);
            Integer totalPrice = prices.sum();
            return c.getBudget() > totalPrice;
        };

        List<String> customerNameList = customerStream.filter(havingEnoughMoney).map(Customer::getName).collect(Collectors.toList());

        assertThat(customerNameList, hasSize(7));
        assertThat(customerNameList, hasItems("Joe", "Patrick", "Chris", "Kathy", "Alice", "Andrew", "Amy"));
    }
}
