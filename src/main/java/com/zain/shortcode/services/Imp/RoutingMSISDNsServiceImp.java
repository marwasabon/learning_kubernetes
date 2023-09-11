package com.zain.shortcode.services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.RoutingMSISDNs;
import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.repository.RoutingMSISDNsRepository;
import com.zain.shortcode.repository.ShortCodeRepository;
import com.zain.shortcode.services.RoutingMSISDNsService;

/**
 * @author m.sabon
 *
 */
@Service
public class RoutingMSISDNsServiceImp implements RoutingMSISDNsService {

	@Autowired
	private RoutingMSISDNsRepository RoutingMSISDNsRepositsory;
	@Autowired
	private ShortCodeRepository shortcoderepo;

	@Override
	public RoutingMSISDNs get_RoutingMSISDNs_ById(Long id) {
		// TODO Auto-generated method stub
		return RoutingMSISDNsRepositsory.findById(id).get();

	}

	@Override
	public List<RoutingMSISDNs> get_All_RoutingMSISDNs() {
		// TODO Auto-generated method stub
		return (List<RoutingMSISDNs>) RoutingMSISDNsRepositsory.findAll();
	}

	@Override
	public RoutingMSISDNs add_RoutingMSISDNs(RoutingMSISDNs routingMSISDNs, Long shorcodeID) throws Exception {
		// TODO Auto-generated method stub    List<RoutingMSISDNs> routingMSISDNsList = RoutingMSISDNRepositsory.findAllByroutingMSISDN(routingMSISDNs.getRoutingMSISDN().trim());

		  List<RoutingMSISDNs> op = RoutingMSISDNsRepositsory.findAllByroutingMSISDN(routingMSISDNs.getRoutingMSISDN().trim());
		System.out.println("-----------------"+op);
		System.out.println(shorcodeID);
	 

	    if (!op.isEmpty()) {
			throw new Exception("RoutingMSISDNs " + routingMSISDNs.getRoutingMSISDN() + "  Already Exists");
			
		}
		try {
			/*
			 * ShortCode shortcode = shortcoderepo.findByshortcodeID(shortcodeID)
			 * .orElseThrow(() -> new Exception("Shortcode not found"));
			 */
			Optional<ShortCode> shortcode = this.shortcoderepo.findByshortcodeID(shorcodeID);
			System.out.println("sssssssssssss"+shortcode);
			if (shortcode.isPresent()) {
			    routingMSISDNs.setShortcode(shortcode.get());
			    RoutingMSISDNs new_RoutingMSISDNs = RoutingMSISDNsRepositsory.save(routingMSISDNs);
			    return new_RoutingMSISDNs;
			} else {
			    throw new Exception("ShortCode not found");
			}

			/*
			 * System.out.println(shortcode); routingMSISDNs.setShortcode(shortcode);
			 * RoutingMSISDNs new_RoutingMSISDNs =
			 * RoutingMSISDNsRepositsory.save(routingMSISDNs); return new_RoutingMSISDNs;
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something went wrong");
		}

	}

	@Override
	public void delete_RoutingMSISDNs_ById(Long id) {
		// TODO Auto-generated method stub
		RoutingMSISDNsRepositsory.deleteById(id);
	}

	@Override
	public void update_RoutingMSISDNs(RoutingMSISDNs newRoutingMSISDNs, RoutingMSISDNs oringial,
			Long shorcodeID) {
		// TODO Auto-generated method stub
		try {
		ShortCode shortcode = (ShortCode) this.shortcoderepo.findByshortcodeID(shorcodeID).get();

		oringial.setRoutingMSISDNID(newRoutingMSISDNs.getRoutingMSISDNID());

		oringial.setRoutingMSISDN(newRoutingMSISDNs.getRoutingMSISDN());
		System.out.println("------------------"+newRoutingMSISDNs.getRoutingMSISDN());
		System.out.println("------------------"+newRoutingMSISDNs.getRoutingMSISDN());

		oringial.setShortcode(shortcode);
		System.out.println("oringial"+oringial);
		System.out.println("shortcode       "+shortcode.getRoutingMSISDNs());
		RoutingMSISDNsRepositsory.save(oringial);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}