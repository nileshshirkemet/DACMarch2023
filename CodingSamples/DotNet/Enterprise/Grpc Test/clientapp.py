import sys
import grpc
from order_manager_pb2 import *
from order_manager_pb2_grpc import OrderManagerStub

with grpc.insecure_channel('localhost:4030') as channel:
	client = OrderManagerStub(channel)
	cust = sys.argv[1].upper()
	if len(sys.argv) > 3:
		prod = int(sys.argv[2])
		qnty = int(sys.argv[3])
		try:
			request = OrderInput(customer_code=cust, item_code=prod, item_count=qnty)
			reply = client.PlaceOrder(request)
			print('New order number is', reply.confirmation_code)
		except grpc.RpcError as fault:
			print(fault.details())
	else:
		request = CustomerInput(customer_code=cust)
		reply = client.FetchOrders(request)
		for order in reply:
			print(f'{order.item_code}\t{order.item_count}\t{order.confirmation_date}')

#pip install grpcio grpcio-tools
#python -m grpc_tools.protoc --python_out=. --grpc_python_out=. -I Sales order_manager.proto

