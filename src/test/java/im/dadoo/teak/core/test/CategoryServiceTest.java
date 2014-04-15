/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.core.test;

import im.dadoo.teak.core.service.CategoryService;
import im.dadoo.teak.core.test.configuration.Context;
import im.dadoo.teak.domain.Category;
import org.junit.After;
import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author codekitten
 */
@RunWith(JUnit4.class)
public class CategoryServiceTest {
  
  private static CategoryService categoryService;
  
  @BeforeClass
  public static void init() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(Context.class);
    CategoryServiceTest.categoryService = ctx.getBean(CategoryService.class);
  }
  
  @After
  public void destroy() {
    categoryService.deleteAll();
  }
  
  @Test
  public void saveAndDelete() {
    Category c1 = categoryService.save("ctest1", "");
    Category c2 = categoryService.findById(c1.getId());
    Assert.assertEquals("ctest1", c2.getName());
  }
  
  @Test
  public void findById() {
    Category c1 = categoryService.findById(Integer.SIZE);
    Assert.assertNull(c1);
    c1 = categoryService.save("ctest1", "");
    Category c2 = categoryService.findById(c1.getId());
    Assert.assertEquals("ctest1", c2.getName());
  }
  
}
