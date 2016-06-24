<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Login</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label for="inputEmail" class="col-xs-1 control-label glyphicon glyphicon-user" style="margin: auto;"> </label>
						<div class="col-xs-10">
							<input type="email" class="form-control" id="inputEmail" placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-xs-1 control-label glyphicon glyphicon-lock" style="margin: auto;"> </label>
						<div class="col-xs-10">
							<input type="password" class="form-control" id="inputPassword" placeholder="Password">
						</div>
					</div>
					<div>
						<input type="submit" class="btn btn-primary btn-sm btn-block" value="Login">
					</div>
				</form>
				<div class="text-right">
					<a href="signup.mb"><font size="1.0">Sign up</font></a>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->