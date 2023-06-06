const serverApi = "api/sales"; 

function App() {
	const orderInput = React.useRef({
		'customerId': '', 
		'productNo': 0, 
		'quantity': 0
	});
	const [customerOrders, setCustomerOrders] = React.useState([]);
	const [statusMessage, setStatusMessage] = React.useState('');
	const getOrders = async () => {
		var response = await fetch(`${serverApi}/${orderInput.current.customerId}`);
		if(response.ok) {
			setCustomerOrders(await response.json());
			setStatusMessage('Orders of Customer');
		}else{
			setCustomerOrders([]);
			setStatusMessage('Orders Not Found');
		}
	};
	const postOrder = async () => {
		setCustomerOrders([]);
		var request = {
			method: 'post',
			headers: {'Content-Type': 'application/json'},
			body: JSON.stringify(orderInput.current)
		};
		var response = await fetch(serverApi, request);
		if(response.ok){
			var result = await response.json();
			setStatusMessage(`Order ${result.orderNo} Placed`);
		}else{
			setStatusMessage('Order Failed');
		}
	};
	return (
		<div>
			<h1>Welcome Sales Agent</h1>
			<p>
				<b>Customer ID: </b>
				<input onChange={e => orderInput.current.customerId = e.target.value}/>
				<button onClick={getOrders}>Orders</button>
			</p>
			<div className='form-entry'>
				<div><b>Product No</b></div>
				<div>
					<input onChange={e => orderInput.current.productNo = e.target.value}/>
				</div>
			</div>
			<div className='form-entry'>
				<div><b>Quantity</b></div>
				<div>
					<input onChange={e => orderInput.current.quantity = e.target.value}/>
				</div>
			</div>
			<button onClick={postOrder}>Order</button>
			<h3>{statusMessage}</h3>
			<InvoiceView ordersList={customerOrders}/>
		</div>
	)
}

function InvoiceView({ordersList}) {
	return (
		<div>
		{ordersList.length > 0 ? (
			<table border="1">
				<tr>
					<th>Product No</th>
					<th>Quantity</th>
					<th>Order Date</th>
				</tr>
				{ordersList.map((entry, index) => (
					<tr key={index}>
						<td>{entry.productNo}</td>
						<td>{entry.quantity}</td>
						<td>{entry.orderDate}</td>
					</tr>
				))}
			</table>
		) : null}
		</div>
	)
}


ReactDOM.createRoot(document.getElementById('root')).render(
	<React.StrictMode>
		<App/>
	</React.StrictMode>
);



