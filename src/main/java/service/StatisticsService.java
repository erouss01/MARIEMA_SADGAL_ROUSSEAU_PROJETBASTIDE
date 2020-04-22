/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import comptoirs.model.dao.StatisticsDao;
import comptoirs.model.dto.StatsResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
//import util.HtmlSqlDate;

/**
 *
 * @author Kency
 */
@Path("service")
public class StatisticsService {

	@Inject
	StatisticsDao dao;

	/*@GET
	@Path("unitesVendues/categories")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult> unitesVenduesJSON() {
            return dao.unitesVenduesParCategorieDTO();
	}*/

	@GET
	@Path("unitesVendues/produits")
        @Produces(MediaType.APPLICATION_JSON)
	public List<StatsResult> produitsVendusParCategorie(
                @QueryParam("codeCat") Integer codeCategorie,
		@QueryParam("minCat") String minDate,
		@QueryParam("maxCat") String maxDate) throws ParseException {
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date min=formatter.parse(minDate);
                Date max=formatter.parse(maxDate);
            return dao.produitsVendusParCategorie(codeCategorie,min,max);
	}

        @GET
	@Path("unitesVendues/pays")
        @Produces(MediaType.APPLICATION_JSON)
	public List<StatsResult> produitsVendusparPays(
                @QueryParam("codePays") String pays,
		@QueryParam("minPays") String minDate,
		@QueryParam("maxPays") String maxDate) throws ParseException {
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date min=formatter.parse(minDate);
                Date max=formatter.parse(maxDate);
            return dao.produitsVendusParPays(pays,min,max);
	}
        
        @GET
	@Path("unitesVendues/client")
        @Produces(MediaType.APPLICATION_JSON)
	public List<StatsResult> produitsVendusParClient(
                @QueryParam("codeClient") String codeClient,
		@QueryParam("minClient") String minDate,
		@QueryParam("maxClient") String maxDate) throws ParseException {
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date min=formatter.parse(minDate);
                Date max=formatter.parse(maxDate);
            return dao.produitsVendusParClient(codeClient,min,max);
	}
        
	/*@GET
	@Path("commandesFiltrees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Integer> commandesFiltrees(
		@QueryParam("minDate") String minDate,
		@QueryParam("maxDate") String maxDate) throws ParseException {
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date min=formatter.parse(minDate);
                Date max=formatter.parse(maxDate);
		return dao.commandesEntre(min, max);
	}*/ 

}

