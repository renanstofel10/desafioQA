# Created: 02/03/2019
class Descontos
  def genero_item(id)
    case id
    when 1 then 'Fantasia'
    when 2 then 'Comédia'
    when 3, 4 then 'Ação'
    when 5 then 'Drama'
    when 6 then 'Animação'
    end
  end

  def preco_item(id)
    case id
    when 1 then 45
    when 2, 4 then 55
    when 3, 5 then 100
    when 6 then 200
    end
  end

  def valor_compra(list)
    total = 0

    list.each do |id|
      valor_produto = preco_item(id)
      total += valor_produto
    end

    total
  end

  def desconto_valor(valor)
    case valor
    when 0..99 then 0
    when 100..199 then 10
    when 200..299 then 20
    when 300..399 then 25
    else; 30
    end
  end

  def desconto_gereno(list)
    array_generos = []
    desc_extra = 0

    list.each do |id|
      array_generos << genero_item(id)
    end

    desc_extra = 5 if array_generos.include? 'Ação'

    desc_extra
  end

  def porcentagem_desconto(list, valor)
    desconto_valor(valor) + desconto_gereno(list)
  end

  def valor_desconto(valor, porcentagem)
    valor * porcentagem / 100
  end
end
