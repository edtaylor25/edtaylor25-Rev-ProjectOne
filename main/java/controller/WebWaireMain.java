package controller;

import exception.ApplicationException;
import io.javalin.Javalin;
import pojo.ErrorPojo;
import pojo.ReimbursementPojo;
import pojo.UserPojo;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class WebWaireMain {
	public static void main(String[] args) {
		
		ReimbursementService reimbursementService = new ReimbursementServiceImpl();
		UserService userService = new UserServiceImpl();
		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4040);
		
		server.post("api/registerUser", (ctx) -> {
			UserPojo returnUserPojo = userService.register(ctx.bodyAsClass(UserPojo.class));
			ctx.json(returnUserPojo);
		});
		
		server.post("api/user/validate",(ctx) -> {
			UserPojo returnUserPojo = userService.validate(ctx.bodyAsClass(UserPojo.class));
			ctx.json(returnUserPojo);
		});
		
		server.get("api/allUser" , (ctx) -> {
			ctx.json(userService.getAllUsers());
			
		});
		
		server.put("api/updateUser", (ctx) -> {
			UserPojo returnUserPojo = userService.updateUser(ctx.bodyAsClass(UserPojo.class));
			ctx.json(returnUserPojo);
		});
		
		server.post("api/addReimbursement", (ctx) -> {
			ReimbursementPojo returnReimbursementPojo = reimbursementService.addReimbursement(ctx.bodyAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbursementPojo);
		});
		
		server.get("api/pendingReimbursement/{bid}", (ctx) -> {
		ctx.json(reimbursementService.getEmployeePendingReimbursements(Integer.parseInt(ctx.pathParam("bid"))));		
	});
		
		server.get("api/resolvedReimbursement/{bid}", (ctx) -> {
			ctx.json(reimbursementService.getEmployeeResolvedReimbursements(Integer.parseInt(ctx.pathParam("bid"))));		
		});
		
		server.get("api/allReimbursement/all" , (ctx) -> {
			ctx.json(reimbursementService.allReimbursements());
			
		});
		
		server.put("api/updateReimbursement", (ctx) -> {
			ReimbursementPojo returnReimbursementPojo = reimbursementService.updateReimbursement(ctx.bodyAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbursementPojo);
		});
		
		server.get("api/allPendingRreimbursement/pending" , (ctx) -> {
			ctx.json(reimbursementService.viewAllPendingReimbursements());
			
		});
		
		server.get("api/allResolvedReimbursement/resolved" , (ctx) -> {
			ctx.json(reimbursementService.viewAllResolvedReimbursements());
			
		});
		
		server.exception(ApplicationException.class, (ae, ctx) -> {
			ErrorPojo error = new ErrorPojo();
			error.setErrorMessage(ae.getMessage());
			ctx.json(error).status(500);
		});
	}
}
