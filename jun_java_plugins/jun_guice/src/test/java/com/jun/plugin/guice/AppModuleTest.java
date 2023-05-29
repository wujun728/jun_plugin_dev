package com.jun.plugin.guice;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.jun.plugin.guice.app.AppModule;
import com.jun.plugin.guice.item.ItemService;
import com.jun.plugin.guice.item.ItemServiceImpl1;
import com.jun.plugin.guice.item.ItemServiceImpl2;
import com.jun.plugin.guice.named.NamedService;
import com.jun.plugin.guice.order.Order;
import com.jun.plugin.guice.order.OrderService;
import com.jun.plugin.guice.order.OrderServiceImpl;
import com.jun.plugin.guice.price.PriceService;
import com.jun.plugin.guice.runtime.RuntimeService;
import com.jun.plugin.guice.runtime.RuntimeServiceImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppModuleTest {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AppModule(new RuntimeServiceImpl()));
    }

    @Test
    public void should_get_order_service_from_guice_module() throws Exception {
        //given
        //when
        final OrderService instance = injector.getInstance(OrderService.class);
        //then
        assertThat(instance, is(instanceOf(OrderServiceImpl.class)));
        final List<ItemService> itemServices = Lists.newArrayList(((OrderServiceImpl) instance).getItemServices());
        assertThat(itemServices.get(0), is(instanceOf(ItemServiceImpl1.class)));
        assertThat(itemServices.get(1), is(instanceOf(ItemServiceImpl2.class)));
        assertThat(((OrderServiceImpl) instance).getPriceService(), is(instanceOf(PriceService.class)));
        instance.add(new Order(100));
    }

    @Test
    public void should_get_all_item_service() throws Exception {
        //given

        //when
        final List<ItemService> instance = Lists.newArrayList(
                injector.getInstance(new Key<Set<ItemService>>() {
                })
        );
        //then
        assertThat(instance.size(), is(2));
        assertThat(instance.get(0), is(instanceOf(ItemServiceImpl1.class)));
        assertThat(instance.get(1), is(instanceOf(ItemServiceImpl2.class)));
    }

    @Test
    public void should_register_service_runtime() throws Exception {
        //given

        //when
        final RuntimeService instance = injector.getInstance(RuntimeService.class);
        //then

        assertThat(instance, is(instanceOf(RuntimeServiceImpl.class)));
    }

    @Test
    public void should_be_singleton_for_one_without_interface_bean() throws Exception {
        //given

        //when
        final PriceService first = injector.getInstance(PriceService.class);
        final PriceService second = injector.getInstance(PriceService.class);
        //then

        assertThat(first, is(sameInstance(second)));
    }

    @Test
    public void should_get_named_service_with_Provides_bean() throws Exception {
        //given

        //when
        final List<NamedService> namedServices = injector.getInstance(new Key<List<NamedService>>() {
        });
        //then

        assertThat(namedServices.size(), is(2));
    }
}