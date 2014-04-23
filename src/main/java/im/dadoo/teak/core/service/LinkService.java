/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.teak.core.service;

import im.dadoo.teak.core.dao.LinkDao;
import im.dadoo.teak.domain.Link;
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
public class LinkService {
  
  @Resource
  private LinkDao linkDao;
  
  public Link save(String name, String url, String description) {
    Link link = Link.create(name, url, description);
    return this.linkDao.save(link);
  }
  
  public void deleteById(Integer id) {
    this.linkDao.deleteById(id);
  }
  
  public List<Link> list() {
    return this.linkDao.list();
  }
}
