<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Invoice</title>
	<link rel="stylesheet" href="bs_grid/bootstrap.css">
	<style>
	@import url(http://fonts.googleapis.com/css?family=Bree+Serif);
	body, h1, h2, h3, h4, h5, h6{
		font-family: 'Bree Serif', serif;
	}
	</style>
</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-xs-6">
			  <h1>
			      <img src="resources/img/logo.png">
			  </h1>
			</div>
			<div class="col-xs-6 text-right">
			  <h1>INVOICE</h1>
			  <h1><small>VAT Invoice #001</small></h1>
			</div>
		</div>

		  <div class="row">
		    <div class="col-xs-5">
		      <div class="panel panel-default">
		              <div class="panel-heading">
		                <h4>From: <a href="#">M/S Manakpur Lime Stone Khanij Udyog</a></h4>
		              </div>
		              <div class="panel-body">
		                <p>
		                  'Ram Bhawan' <br>
		                  Near Railway Station <br>
		                  P.O : Gotan - 342902 <br>
		                  Distt : Nagaur (Raj.)
		                </p>
		              </div>
		            </div>
		    </div>
		    <div class="col-xs-5 col-xs-offset-2 text-right">
		      <div class="panel panel-default">
		              <div class="panel-heading">
		                <h4>To : <a href="#">Aggarwal Lime Industries</a></h4>
		              </div>
		              <div class="panel-body">
		                <p>
		                  Gotan (Rajasthan)<br>
		                </p>
		              </div>
		            </div>
		    </div>
		  </div> <!-- / end client details section -->

		         <table class="table table-bordered">
        <thead>
          <tr>
            <th><h4>Perticulars</h4></th>
            <th><h4>Description</h4></th>
            <th><h4>Quantity(M.T)</h4></th>
            <th><h4>Rate/Price(P.M.T)</h4></th>
            <th><h4>Amount</h4></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Article</td>
            <td><a href="#">Title of your article here</a></td>
            <td class="text-right">-</td>
             <td class="text-right">$200.00</td>
              <td class="text-right">$200.00</td>
          </tr>
          <tr>
            <td>Template Design</td>
            <td><a href="#">Details of project here</a></td>
            <td class="text-right">10</td>
             <td class="text-right">75.00</td>
              <td class="text-right">$750.00</td>
          </tr>
          <tr>
            <td>Development</td>
            <td><a href="#">WordPress Blogging theme</a></td>
            <td class="text-right">5</td>
             <td class="text-right">50.00</td>
              <td class="text-right">$250.00</td>
          </tr>
        </tbody>
      </table>

		<div class="row text-right">
			<div class="col-xs-2 col-xs-offset-8">
				<p>
					<strong>
						Sub Total : <br>
						VAT/CST (@ 5%) : <br>
						Total : <br>
					</strong>
				</p>
			</div>
			<div class="col-xs-2">
				<strong>
					$1200.00 <br>
					N/A <br>
					$1200.00 <br>
				</strong>
			</div>
		</div>


		<div class="row">
		  <div class="col-xs-5">
		    <div class="panel panel-info">
			   <div class="panel-heading">
			      <h4>Contact Details</h4>
			    </div>
			    <div class="panel-body">
			      <p>
			        Email : ramksuthar@gmail.com <br><br>
			        Mobile : 9414813383<br> <br>
			      </p>
			      <h4>Payment should be mabe by Bank Transfer</h4>
			    </div>
			</div>
		  </div>
		  <div class="col-xs-7">
		   <div class="span7">
			  <div class="panel panel-info">
			    <div class="panel-heading">
			      <h4>For Manakpur Lime Stone Khanij Udhyog</h4>
			    </div>
			    <div class="panel-body">
			      <p>
			          <br><br>
			          <br> <br>
			      </p>
			      <h4>Manager</h4>
			    </div>
			  </div>
			</div>
		  </div>
		</div>

	</div>

</body>
</html>