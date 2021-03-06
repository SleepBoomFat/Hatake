package boot.spring.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.spring.pagemodel.CityGrid;
import boot.spring.po.City;
import boot.spring.po.Country;
import boot.spring.service.CityService;
import redis.clients.jedis.JedisCluster;


@Controller
public class CityController {
	@Autowired
	CityService cityservice;
	/*@Autowired
	JedisCluster jedisCluster;*/
	private static final String cityKey = "REDIS_CITY_KEY";

	@RequestMapping("/getcitys")
	@ResponseBody
	CityGrid getcitys(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		/*CityGrid c  = (CityGrid)JSON.parse(jedisCluster.get(cityKey));//先从缓存中查找key对应的数据 cityid = key
		如果缓存中存在，则直接返回查找到的数据
		if(c != null){
			return c;
		}else{
			int total=cityservice.getCitylist().size();
			//否则从数据库查
			List<City> list=cityservice.getpagecitylist(current,rowCount);
			CityGrid grid=new CityGrid();
			grid.setCurrent(current);
			grid.setRowCount(rowCount);
			grid.setRows(list);
			grid.setTotal(total);
			//并且将查到的数据加入到REDIS中，这样下次查就可以从缓存中查到数据了
			jedisCluster.set(cityKey,JSON.toJSONString(grid));
			return grid;
		}*/
		int total=cityservice.getCitylist().size();
		List<City> list=cityservice.getpagecitylist(current,rowCount);
		CityGrid grid=new CityGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;


	}
	
	@RequestMapping("/city")
	String city(){
		return "city";
	}
	
	@RequestMapping("/country")
	String country(){
		return "country";
	}
	
	@RequestMapping("/getchainacity")
	@ResponseBody
	CityGrid getchinacity(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		List<City> citys=cityservice.getCountryCity("China");
		int total=citys.size();
		List<City> clist=cityservice.getpageCountryCity("China", current, rowCount);
		CityGrid grid=new CityGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(clist);
		grid.setTotal(total);
		return grid;
	}
	
	
	@RequestMapping("/countrycity")
	@ResponseBody
	Country getcountrycity(@RequestParam("country")String country){
		Country a=cityservice.getCountryCitys(country);
		return a;
	}
	
}
