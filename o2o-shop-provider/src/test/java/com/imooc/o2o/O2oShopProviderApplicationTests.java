package com.imooc.o2o;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class O2oShopProviderApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private ShopService shopService;

    @Test
    public void shopTest() {
        Shop shop = new Shop();
        PersonInfo user = new PersonInfo();
        Area area = new Area();
        ShopCategory category = new ShopCategory();

        user.setUserId(1l);
        user.setName("admin");
        area.setAreaId(1);
        area.setAreaName("东区");
        category.setShopCategoryId(1l);
        category.setShopCategoryName("咖啡馆");
        shop.setShopName("咖啡馆");
        shop.setShopCategory(category);
        shop.setArea(area);
        shop.setUser(user);
        shop.setEnableStatus(1);
        shop.setPhone("1369556487");
        shop.setPriority(2);
        shop.setShopDesc("咖啡很好喝，价格很实惠");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setAdvice("1");
        shop.setShopAddr("上海市");
        shop.setShopImg("/upload/view.shop/1.jsp");
//        int effectNum = shopService.insertShop(shop);
//        System.out.println(effectNum);
    }

}
