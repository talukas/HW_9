package core;

import java.text.DecimalFormat;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/")

public class Imperial_to_Metric_JSON_Factory {

	DecimalFormat df = new DecimalFormat("####0.00");
	JsonBuilderFactory factory = Json.createBuilderFactory(null);

	@GET
	@Path("json/in=>cm")
	@Produces("application/json")
	public Response in_to_cm(@QueryParam("input") Double input) {

		Double in = input;
		Double cm = in * 2.54;
		String in_out = df.format(in).toString();
		String cm_out = df.format(cm).toString();
		JsonObject json = factory.createObjectBuilder()

				.add("calc",factory.createObjectBuilder()
				.add("conversion", "in to cm")
				.add("in", in_out).add("cm", cm_out))
				.build();

		System.out.println(json);
		String out = json.toString();
		return Response.status(200).entity(out).build();

	}

	@GET
	@Path("json/cm=>in")
	@Produces("application/json")
	public Response cm_to_in(@QueryParam("input") Double input) {

		Double cm = input;
		Double in = cm * 0.3937;
		String in_out = df.format(in).toString();
		String cm_out = df.format(cm).toString();

		JsonObject json = factory.createObjectBuilder()

				.add("calc",factory.createObjectBuilder()
				.add("conversion", "cm to in")
				.add("in", in_out).add("cm", cm_out))
				.build();

		System.out.println(json);
		String out = json.toString();
		return Response.status(200).entity(out).build();

	}

	@GET
	@Path("json/lb=>kg")
	@Produces("application/json")
	public Response lb_to_kg(@QueryParam("input") Double input) {

		Double lb = input;
		Double kg = lb * 0.4536;
		String lb_out = df.format(lb).toString();
		String kg_out = df.format(kg).toString();

		JsonObject json = factory.createObjectBuilder()

				.add("calc",factory.createObjectBuilder()
				.add("conversion", "lb to kg")
				.add("lb", lb_out).add("kg", kg_out))
				.build();

		System.out.println(json);
		String out = json.toString();
		return Response.status(200).entity(out).build();

	}

	@GET
	@Path("json/kg=>lb")
	@Produces("application/json")
	public Response kg_to_lb(@QueryParam("input") Double input) {

		Double kg = input;
		Double lb = kg * 2.2046;
		String lb_out = df.format(lb).toString();
		String kg_out = df.format(kg).toString();

		JsonObject json = factory.createObjectBuilder()

				.add("calc", factory.createObjectBuilder()
				.add("conversion", "kg to lb").add("lb", lb_out).add("kg", kg_out))
				.add("other conversions", factory.createArrayBuilder()
				.add(factory.createObjectBuilder()
				.add("lenght", "cm to in").add("temperature", "C to F"))

				)

				.build();

		System.out.println(json);
		String out = json.toString();
		return Response.status(200).entity(out).build();
	}

}
