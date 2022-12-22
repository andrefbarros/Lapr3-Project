CREATE OR REPLACE PACKAGE BODY operacoes AS

  PROCEDURE cancel_operacao (operacao_id Operacao.id_operacao%TYPE) IS
  data_prevista TIMESTAMP;
  data_op TIMESTAMP;
  BEGIN

    SELECT data_prevista_operacao, data_operacao
    INTO data_prevista, data_op
    FROM Operacao
    WHERE id_operacao = operacao_id;

    IF data_prevista IS NOT NULL AND data_op IS NOT NULL THEN
      RAISE_APPLICATION_ERROR(-20001, 'Operação já realizada');
    ELSE IF data_prevista IS NOT NULL AND data_op IS NULL THEN
      UPDATE Operacao
      SET data_prevista_operacao = NULL
      WHERE id_operacao = operacao_id;
    END IF;
    END IF;

  END cancel_operacao;

  PROCEDURE atualizar_operacao_datas(operacao_id Operacao.id_operacao%TYPE, data_nova TIMESTAMP) IS
  data_prevista TIMESTAMP;
  data_op TIMESTAMP;
  BEGIN
  SELECT data_prevista_operacao, data_operacao
    INTO data_prevista, data_op
    FROM Operacao
    WHERE id_operacao = operacao_id;

    IF data_prevista IS NOT NULL AND data_op IS NOT NULL THEN
      RAISE_APPLICATION_ERROR(-20001, 'Operação já realizada');
    ELSE IF data_prevista IS NOT NULL AND data_op IS NULL THEN
      UPDATE Operacao
      SET data_prevista_operacao = data_nova
      WHERE id_operacao = operacao_id;
    END IF;
    END IF;

  END atualizar_operacao_datas;

END operacoes;
