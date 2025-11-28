INSERT INTO conseiller (id, nom, prenom) VALUES (1, 'Martin', 'Paul');

INSERT INTO client (id, nom, prenom, adresse, ville, telephone, conseiller_id)
VALUES (1, 'Dupont', 'Alice', '10 rue Test', 'Paris', '0601020304', 1);


INSERT INTO compte (type_compte, id, numero_compte, solde, date_ouverture, decouvert_autorise, client_id)
VALUES ('COURANT', 100, 'CC-ALICE-01', 500.0, CURRENT_DATE, 1000.0, 1);

INSERT INTO compte (type_compte, id, numero_compte, solde, date_ouverture, taux_remuneration, client_id)
VALUES ('EPARGNE', 200, 'CE-ALICE-01', 5001.0, CURRENT_DATE, 0.03, 1);

INSERT INTO carte_bancaire (id, numero, type, active, client_id)
VALUES (50, '1111-2222-3333-4444', 'VISA_PREMIER', true, 1);

ALTER TABLE conseiller ALTER COLUMN id RESTART WITH 100;
ALTER TABLE client ALTER COLUMN id RESTART WITH 100;
ALTER TABLE compte ALTER COLUMN id RESTART WITH 1000;
ALTER TABLE carte_bancaire ALTER COLUMN id RESTART WITH 100;