SET
@shipment_id_1 = 'a0000000-0000-0000-0000-000000000001';

SET
@income_id_1 = 'b0000000-0000-0000-0000-000000000001';
SET
@income_id_2 = 'b0000000-0000-0000-0000-000000000002';
SET
@income_id_3 = 'b0000000-0000-0000-0000-000000000003';

SET
@cost_id_1 = 'c0000000-0000-0000-0000-000000000001';
SET
@cost_id_2 = 'c0000000-0000-0000-0000-000000000002';
SET
@cost_id_3 = 'c0000000-0000-0000-0000-000000000003';

SET
@profit_id_1 = 'd0000000-0000-0000-0000-000000000001';
SET
@profit_id_2 = 'd0000000-0000-0000-0000-000000000002';
SET
@profit_id_3 = 'd0000000-0000-0000-0000-000000000003';


INSERT INTO shipment (id, tracking_number)
VALUES (@shipment_id_1, '0001');

INSERT INTO income (id, income)
VALUES (@income_id_1, 500.00),
       (@income_id_2, 650.00),
       (@income_id_3, 400.00);

INSERT INTO cost (id, costs, additional_costs, total_cost)
VALUES (@cost_id_1, 150.00, 25.00, 175.00),
       (@cost_id_2, 200.00, -50.00, 150.00),
       (@cost_id_3, 100.00, 10.00, 110.00);


INSERT INTO profit (id, shipment_id, cost_id, income_id, profit)
VALUES (@profit_id_1, @shipment_id_1, @cost_id_1, @income_id_1, 325.00),
       (@profit_id_2, @shipment_id_1, @cost_id_2, @income_id_2, 400.00),
       (@profit_id_3, @shipment_id_1, @cost_id_3, @income_id_3, 290.00);