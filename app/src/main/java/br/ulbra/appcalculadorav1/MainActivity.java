package br.ulbra.appcalculadorav1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres,
            numeroQuatro, numeroCinco, numeroSeis, numeroSete,
            numeroOito, numeroNove, ponto, divisao, multiplicacao,
            soma, subtracao, igual, botao_limpar, mod, raiz;
    private TextView txtExpressao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();
        iniciarComponentes();
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        mod.setOnClickListener(this);


        raiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                int numero = Integer.parseInt(expressao.getText().toString());
                int raizQuadrada = (int) Math.sqrt(numero);


                txtResultado.setText(raizQuadrada);
            }
        });


        botao_limpar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtExpressao.setText("");
                        txtResultado.setText("");
                    }
                }
        );
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if (!string.isEmpty()) {
                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });
        raiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtExpressao.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Coloque o numero antes!", Toast.LENGTH_SHORT).show();
                } else {
                    double valor = Double.parseDouble(txtExpressao.getText().toString());
                    txtResultado.setText(String.valueOf(Math.sqrt(valor)));
                }
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;
                    if (resultado == (double) longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch (Exception e) {

                }

            }
        });
    }


    private void iniciarComponentes() {
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);

        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.adicao);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        mod = findViewById(R.id.mod);
        raiz = findViewById(R.id.raiz);


        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void acrescentarUmaExpressao(String string, boolean limpar_dados) {

        if (txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");
        }
        if (limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.numero_zero:
                acrescentarUmaExpressao("0", true);
                break;
            case R.id.numero_um:
                acrescentarUmaExpressao("1", true);
                break;
            case R.id.numero_dois:
                acrescentarUmaExpressao("2", true);
                break;
            case R.id.numero_tres:
                acrescentarUmaExpressao("3", true);
                break;
            case R.id.numero_quatro:
                acrescentarUmaExpressao("4", true);
                break;
            case R.id.numero_cinco:
                acrescentarUmaExpressao("5", true);
                break;
            case R.id.numero_seis:
                acrescentarUmaExpressao("6", true);
                break;
            case R.id.numero_sete:
                acrescentarUmaExpressao("7", true);
                break;
            case R.id.numero_oito:
                acrescentarUmaExpressao("8", true);
                break;
            case R.id.numero_nove:
                acrescentarUmaExpressao("9", true);
                break;
            case R.id.adicao:
                acrescentarUmaExpressao("+", true);
                break;
            case R.id.subtracao:
                acrescentarUmaExpressao("-", true);
                break;
            case R.id.multiplicacao:
                acrescentarUmaExpressao("*", true);
                break;
            case R.id.divisao:
                acrescentarUmaExpressao("/", true);
                break;
            case R.id.ponto:
                acrescentarUmaExpressao(".", true);
                break;
            case R.id.mod:
                acrescentarUmaExpressao("%", true);
                break;

        }
    }
}
