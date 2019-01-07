/*Daftar pelanggan yang beralamat di kota Irvine*/
select * from trn_customers WHERE city = 'Irvine'

/*Daftar semua pelanggan yang pesanannya ditangani karyawan
bernama Adam Barr*/
select * from trn_orders tor
join trn_customers tcn on tor.customer_id = tcn.customer_id
join trn_employees tep on tor.employee_id = tep.employee_id
where tep.first_name like 'Adam'

/*Daftar produk yang dipesan oleh pelanggan Contoso, Ltd*/
select * from trn_orders tor
join trn_customers tcn on tor.customer_id = tcn.customer_id
where tcn.company_name like '%contoso%'

/*Daftar transaksi pemesanan yang dikirimkan melalui UPS Ground*/
select * from trn_orders tor
join trn_customers tcn on tor.customer_id = tcn.customer_id
join trn_shipping_methods tsm on tor.shipping_method_id = tsm.shipping_method_id
where tsm.shipping_method like '%UPS%'

/*Daftar biaya total pemesanan (termasuk pajak dan biaya pengiriman)
setiap
transaksi diurut berdasarkan tanggal transaksi*/
select tor.freight_charge,tor.taxes,tor.payment_received,tor.order_date 
from trn_orders tor
order by tor.order_date desc

