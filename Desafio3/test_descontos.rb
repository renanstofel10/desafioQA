require 'test/unit'
require_relative('./calcula_descontos')

# TDD Tests - Desafio 3 (Noesis)
class TestDescontos < Test::Unit::TestCase
  def test_desconto_carrinho
    calc = Descontos.new
    carrinho = [1, 3, 4, 6]
    valor_compra = calc.valor_compra(carrinho)
    porcentagem_desconto = calc.porcentagem_desconto(carrinho, valor_compra)
    valor_desconto = calc.valor_desconto(valor_compra, porcentagem_desconto)

    assert_equal(porcentagem_desconto, 35)
    assert_equal(valor_desconto, 140.00)
  end
end
