package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Elements;
import utils.Tools;

public class BuyProducts {

    Elements realizar = new Elements();
    Tools acao = new Tools();

    @Given("Estou logado na plataforma automationexercise")
    public void Estou_logado_na_plataforma_automationexercise() {
        acao.webDriverPath();
        realizar.login();
    }

    @And("Adiciono o primeiro produto ao carrinho 2x")
    public void Adiciono_o_primeiro_produto_ao_carrinho_2x() {
        realizar.addFirstProduct();
        realizar.addFirstProduct();
    }

    @And("Adiciono o segundo produto ao carrinho")
    public void Adiciono_o_segundo_produto_ao_carrinho() {
        realizar.addSecondProduct();

    }

    @And("Removo o produto adicionado 2x")
    public void Removo_o_produto_adicionado_2x() {
        realizar.removeTheProductFromCart();

    }
    @Given("Adiciono o produto removido novamente 1x")
    public void adiciono_o_produto_removido_novamente_1x() {
        realizar.navigateAndBuyAgain();
    }

    @When("Realizo o pedido em Proceed to checkout")
    public void realizo_o_pedido_em_proceed_to_checkout() {
    realizar.checkout();
    }
    @Then("Deve ser possivel realizar a compra dos produtos com sucesso.")
    public void deve_ser_possivel_realizar_a_compra_dos_produtos_com_sucesso() {
          realizar.buySucess();
    }
}