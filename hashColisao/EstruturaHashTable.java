package hashColisao;

import javax.naming.InitialContext;

public class EstruturaHashTable implements EstruturaDeDados{
    private Integer tabela[];
    
    public EstruturaHashTable() {
        tabela = new Integer[1100];

    }

    @Override
    public boolean insert(int chave) {
        int indiceTab = CalculaInc(chave); // calcular os indices para apenas as primeira 1000 casa;

        if(tabela[indiceTab] != null){
            
            indiceTab = Recalcular(chave); // calcular o indice para as 100 ultimas casa adicionais.

            if(tabela[indiceTab] != null){
                int i = 0;

                while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trás pra frente.
                    i++;
                }
                if(i == 1000){ // significa que a tabela original está completamente cheia. 
                    return false;
                }

                tabela[1000 - i] = chave;
                return true;
            }

            tabela[indiceTab] = chave; // inserir no porão agora como indice recalculado.
            return true;
        }

        tabela[indiceTab] = chave;
        return true;

    }

    @Override
    public boolean delete(int chave){
        int indiceTab = CalculaInc(chave);

        if(tabela[indiceTab] != null){

            if(tabela[indiceTab] == chave){
                tabela[indiceTab] = null;
                return true;
            }

            indiceTab = Recalcular(chave);

            if(tabela[indiceTab] != null){
                if(tabela[indiceTab] == chave){
                    tabela[indiceTab] = null;
                    return true;
                }
                int i = 0;
                while(i < 1000 && tabela[1000 - i] != null){
                    i++;
                }
                if(i >= 1000){
                    return false;
                }
                else{
                    tabela[1000 - i] = null;
                    return true;
                }
            }
        }
        else{
            indiceTab = Recalcular(chave);

            if(tabela[indiceTab] != null){
                if(tabela[indiceTab] == chave){
                    tabela[indiceTab] = null;
                    return true;
                }
                int i = 0;
                while(i < 1000 && tabela[1000 - i] != null){
                    i++;
                }
                if(i >= 1000){
                    return false;
                }
                else{
                    tabela[1000 - i] = null;
                    return true;
                }
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    @Override
    public int search(int chave) {

        int indiceTab = CalculaInc(chave);

        if(tabela[indiceTab] != null){
            if(tabela[indiceTab] == chave){
                return chave;
            }
            else{
                indiceTab = Recalcular(chave);

                if(tabela[indiceTab] != null){
                    if(tabela[indiceTab] == chave){
                        return chave;
                    }
                    else{
                        int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }
                        
                        return -1;
                    }
                }
                return -1;
            }
        }
        else{
            indiceTab = Recalcular(chave);

                if(tabela[indiceTab] != null){
                    if(tabela[indiceTab] == chave){
                        return chave;
                    }
                    else{
                        int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }
                        
                        return -1;
                    }
                }
                else{
                    int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }

                        return -1;
                }
        }
    }
    
    public int Recalcular(int chave){
        int indicePorão = chave % 100;
        
        return (indicePorão + 1000); // adiciona o 1000 para que eeste seja inserido nas ultimas 100 casa.
    }

    public int CalculaInc(int chave){
        int indice = chave % 1000;
        
        return indice;
    }

}
