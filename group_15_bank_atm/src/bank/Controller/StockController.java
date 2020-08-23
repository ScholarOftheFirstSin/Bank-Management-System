package bank.Controller;

import bank.*;
import bank.View.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StockController {
    private StockListView stockListView;
    private StockBuyView stockBuyView;
    private StockSellView stockSellView;
    private StockPeekView stockPeekView;
    private ManagerStockView managerStockView;
    private changeStockView changeStockView;
    private BoughtStockView boughtStockView;
    private ManagerStockListView managerStockListView;
    public StockController() {
        stockListView = new StockListView();
        //stockTransactionView = new StockTransactionView();
       // stockPredictView = new StockPredict();
        managerStockView = new ManagerStockView();
        managerStockListView = new ManagerStockListView();
        //changeStockView = new changeStockView();
        initController();
    }
    public void StockList()
    {
       stockListView.setVisible(true);
        PanelData.setParentPanel(stockListView);
        bindData();
    }

    public void newStockView()
    {
        managerStockView.setVisible(true);
        PanelData.setParentPanel(managerStockView);

    }

    public void StockListOfManager() {
        managerStockListView.setVisible(true);
        PanelData.setParentPanel(managerStockListView);
        bindDataManger();
    }

    public void stockPredictView() {
        stockPeekView = new StockPeekView();
        stockPeekView.getSaveButton().addActionListener(l ->predict());
        stockPeekView.setVisible(true);
        PanelData.setParentPanel(stockPeekView);
    }

    public void bindData(){




            String col[] = {"Stock Name","Current available share ","Total share","Price"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);




                for (int i = 0; i < Data.getStockMarket().getStocks().size(); i++)
                {
                    Object[] objs = { Data.getStockMarket().getStocks().get(i).getName(),
                            Data.getStockMarket().getStocks().get(i).getCurrentlyAvailableShares()
                            , Data.getStockMarket().getStocks().get(i).getTotalShares()
                            , Data.getStockMarket().getStocks().get(i).getCurrentPrice()

                            };
                    tableModel.addRow(objs);
                }




            JTable table = new JTable(tableModel);
            table.setFillsViewportHeight(true);



           stockListView.setTable(table);


        }

    public void bindDataManger(){




        String col[] = {"Stock Name","Current available share ","Total share","Price"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);




        for (int i = 0; i < Data.getStockMarket().getStocks().size(); i++)
        {
            Object[] objs = { Data.getStockMarket().getStocks().get(i).getName(),
                    Data.getStockMarket().getStocks().get(i).getCurrentlyAvailableShares()
                    , Data.getStockMarket().getStocks().get(i).getTotalShares()
                    , Data.getStockMarket().getStocks().get(i).getCurrentPrice()

            };
            tableModel.addRow(objs);
        }




        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);



        managerStockListView.setTable(table);


    }




    public void initController()
    {
        stockListView.getBuy().addActionListener(l ->stockTransactionBuy());
        stockListView.getSell().addActionListener(l ->stockTransactionSell());
        //stockTransactionView.getSaveButton().addActionListener(l ->sellOrBuyStock());
       // stockPredictView.getSaveButton().addActionListener(l ->predict());
        managerStockView.getSaveButton().addActionListener(l ->newStock());
        stockListView.getStockPeekProfit().addActionListener(l ->stockPredictView());
        managerStockView.getChangeStockButton().addActionListener(l ->changeStockView());
        //changeStockView.getSaveButton().addActionListener(l ->changeStock());

    }

    private void changeStock () {
        String name =(String) changeStockView.getStockComboBox().getSelectedItem();
        String rawTotal = changeStockView.getTotalShareTextField().getText();
        String rawCurrent = changeStockView.getCurrentTextField().getText();
        String rawPrice = changeStockView.getPriceTextField().getText();

        if (rawTotal.equals("") || rawCurrent.equals("") || rawPrice.equals("")) {
            changeStockView.setMsgLabel("Blank field is not allowed!");
        } else{
            int totalShare = Integer.parseInt(changeStockView.getTotalShareTextField().getText());
            int current = Integer.parseInt(changeStockView.getCurrentTextField().getText());
            float price = Float.parseFloat(changeStockView.getPriceTextField().getText());
            if(Data.getStockMarket().changeStockTotalShare(name, totalShare) && Data.getStockMarket().changeStockCurrentShare(name, current) && Data.getStockMarket().changeStockPrice(name, price )){
                changeStockView.setMsgLabel("Successfully changed the attributes of the selected stock");
            }
        }


    }

    private void changeStockView() {
        changeStockView = new changeStockView();
        changeStockView.getSaveButton().addActionListener(l ->changeStock());
        changeStockView.setVisible(true);
        PanelData.setParentPanel(changeStockView);
    }

    private void stockTransactionBuy() {
        stockBuyView = new StockBuyView();
        stockBuyView.getSaveButton().addActionListener(l ->BuyStock());
        stockBuyView.setVisible(true);
        PanelData.setParentPanel(stockBuyView);
    }

    private void stockTransactionSell() {
        stockSellView = new StockSellView();
        stockSellView.getSaveButton().addActionListener(l ->SellStock());
        stockSellView.setVisible(true);
        PanelData.setParentPanel( stockSellView);
    }

    private void BuyStock() {
        String name = (String) stockBuyView.getStockc().getSelectedItem();
        int amount = Integer.parseInt(stockBuyView.getAmountTextField().getText());

        int newCurrent = Data.getStockMarket().getStockByName(name).getCurrentlyAvailableShares() - amount;
        if (amount <= 0) {
            stockBuyView.setMsgLabel("Invalid number!!!!");
        } else if (newCurrent >= 0) {
            LoggedUser.getProfile().getSecurityAccount().addNewSharesToStock(Data.getStockMarket().getStockByName(name), amount);
            Data.getStockMarket().changeStockCurrentShare(name, newCurrent);
            stockBuyView.setMsgLabel("Successfully buy stock!");
        }
        else {
            stockBuyView.setMsgLabel("The amount of share you wanna buy is beyond the total share! ");
        }


    }

    private void SellStock() {
        String name = (String) stockSellView.getStockc().getSelectedItem();
        int amount = Integer.parseInt(stockSellView.getAmountTextField().getText());

        if (amount <= 0) {
            stockSellView.setMsgLabel("Invalid number!!!!");
        } else if (amount <= LoggedUser.getProfile().getSecurityAccount().getBoughtStockByName(name).getAmountOfStocks()) {
                Float profit = LoggedUser.getProfile().getSecurityAccount().sellSharesOfStock(LoggedUser.getProfile().getSecurityAccount().getBoughtStockByName(name).getStock(), amount);
                stockSellView.setMsgLabel("The profit you made is: " + profit);

        } else {
            stockSellView.setMsgLabel("The amount of share you wanna sell is beyond the share you have! ");
        }

    }

    private void predict() {
        String name = (String) stockPeekView.getStockBoughtc().getSelectedItem();
        int amount = Integer.parseInt(stockPeekView.getAmountTextField().getText());
        if (amount >= 0) {
            Float profit = LoggedUser.getProfile().getSecurityAccount().peekPossibleProfit(LoggedUser.getProfile().getSecurityAccount().getBoughtStockByName(name).getStock(), amount);
            stockPeekView.setMsgLabel("The profit you can make is: " + profit);
        }
        else {
            stockPeekView.setMsgLabel("The amount must be bigger than zero");
        }
    }

    private void newStock() {
        String name = managerStockView.getNameTextField().getText();
        String rawTotal = managerStockView.getTotalShareTextField().getText();
        String rawCurrent = managerStockView.getCurrentAvailableShareTextField().getText();
        String rawPrice = managerStockView.getPriceTextField().getText();

        if(name.equals("") || rawCurrent.equals("") || rawPrice.equals("") || rawTotal.equals("")) {
            managerStockView.setMsgLabel("Blank field is not allowed!");
        } else {


            Integer totalShare = Integer.parseInt(rawTotal);
            Integer current = Integer.parseInt(rawCurrent);
            Float price = Float.parseFloat(rawPrice);
            Data.getStockMarket().addStock(name, totalShare, current, price);
            managerStockView.setMsgLabel("Successfully create a new stock");
        }


    }

    public void ShowBoughtStock() {
        boughtStockView = new BoughtStockView();
        boughtStockView.setVisible(true);
        PanelData.setParentPanel(boughtStockView);
        bindDataBoughtStock();

    }

    private void bindDataBoughtStock()
    {

            String col[] = {"Stock Name","The share you have","The Bought Price","Current Price"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);

            for (int i = 0; i < LoggedUser.getProfile().getSecurityAccount().getBoughtStocks().size(); i++)
            {
                Object[] objs = {
                        LoggedUser.getProfile().getSecurityAccount().getBoughtStocks().get(i).getStock().getName(),
                        LoggedUser.getProfile().getSecurityAccount().getBoughtStocks().get(i).getAmountOfStocks(),
                        LoggedUser.getProfile().getSecurityAccount().getBoughtStocks().get(i).returnBoughtPrice(),
                        LoggedUser.getProfile().getSecurityAccount().getBoughtStocks().get(i).getStock().getCurrentPrice()

                };
                tableModel.addRow(objs);
            }

            JTable table = new JTable(tableModel);
            table.setFillsViewportHeight(true);
            boughtStockView.setTable(table);

        }
}
