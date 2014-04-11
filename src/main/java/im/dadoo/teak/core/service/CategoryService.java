/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.core.service;

import im.dadoo.teak.core.dao.CategoryDao;
import im.dadoo.teak.domain.Category;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author codekitten
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CategoryService {
  
  @Resource
  private CategoryDao categoryDao;
  
  public Category save(String name, String description) {
    Category category = this.categoryDao.findByName(name);
    //判断是否出现重名
    if (category == null) {
      category = Category.create(name, description);
      return this.categoryDao.save(category);
    } else {
      return null;
    }
  }
  
  public List<Category> list() {
    return this.categoryDao.list();
  }
}