package com.example.demo.archive.oa;

import java.util.Scanner;

public class Battleship {
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {

//create a board class
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Battleship!\n");
        System.out.println(board + "\n");
        boolean addNew = true;

        while (addNew)
        {
// Ask user to add new ship
            System.out.println("Add a new ship? (y/n)");
            String UserAnswer = scanner.nextLine();
            if (UserAnswer.toLowerCase().equals("y"))
            {

//ask user to defined the ship and its location on the board
                System.out.println("Starting in which row?");
                int row = scanner.nextInt();
                System.out.println("Starting in which column?");
                int column = scanner.nextInt();
                System.out.println("How long?");
                int lengthShip = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Horizontal (h) or vertical (v)?");
                String d = scanner.nextLine();
                boolean horizontal = (d.toLowerCase().equals("h"));

                if (board.addShip(row, column, lengthShip, horizontal))
                {
                    System.out.println("\nNew ship added!\n\n" + board + "\n");
                } else
                    System.out.println("\nCan't put a ship there!\n");
            } else
            {
                addNew = false;
                System.out.println("\nOk, let's play!\n");
            }
        }

        while (!board.gameOver())
        {
//ask user to enter the inpu row
            System.out.println("Input row");
            int row = scanner.nextInt();
//ask user to enter column
            System.out.println("Input column");
            int column = scanner.nextInt();

            int result = board.shoot(row, column);

            if (result == 1)
                System.out.println("\nHit!\n\n" + board + "\n");
            else if (result == 0)
                System.out.println("\nMiss!\n\n" + board + "\n");
            else if (result == 2)
                System.out.println("\nYou already tried that\n");
            else
                System.out.println("\nInvalid coordinates\n");
        }
        System.out.println("Game over!");
    }
}
//Board.java
 class Board {

    //define array of board
    private char[][] squares;

    Board()
    {
//set board 10x10
        squares = new char[10][10];

        for(int r = 0; r < squares.length; ++r)
        {
            for(int i = 0; i < squares[r].length; ++i)
            {
                squares[r][i] = '-';
            }
        }
    }


    @Override
    public String toString()
    {
        String returnstr = "";
        for (char[] row : squares)
        {
            for (char ch : row)
            {
                returnstr += String.valueOf(ch) + " ";
            }
// new row
            returnstr += "\n";
        }
        return returnstr;
    }

    //method to add the ship
    public boolean addShip(int row, int col, int len, boolean horizontal)
    {
        try {
            for(int i = 0; i < len; ++i)
            {
                if (squares[row + (horizontal ? 0 : i)][col + (horizontal ? i : 0)] == 'b')
                {
                    throw new java.lang.ArrayIndexOutOfBoundsException();
                }
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        for(int i = 0; i < len; ++i)
        {
            squares[row + (horizontal ? 0 : i)][col + (horizontal ? i : 0)] = 'b';
        }
        return true;
    }

    //method to shoot a fire
    public int shoot(int row, int col)
    {
        try {
            if(squares[row][col] == '-')
            {
                squares[row][col] = 'm';
                return 0;
            }
            else if(squares[row][col] == 'b')
            {
                squares[row][col] = 'x';
                return 1;
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e)
        {
            return -1;
        }

        return 2;
    }

    //method to trigger game over
    public boolean gameOver()
    {
        for (char[] row : squares)
        {
            for (char c : row)
            {
                if(c == 'b')
                    return false;
            }
        }
        return true;
    }

    //method to found the ship
    public boolean foundShip(int length)
    {

        for (char[] row : squares)
        {
            int shipLength = 0;

            for(int i = 0; i < row.length; ++i)
            {
                if (row[i] == 'b')
                    ++shipLength;
                else if (shipLength > 0 && row[i] != 'b')
                    shipLength = 0;
                if(shipLength == length && i + 1 < row.length && row[i + 1] != 'b')
                    return true;
            }
        }

        for(int iHorizontalRow = 0; iHorizontalRow < squares[0].length; ++iHorizontalRow)
        {
            int shipLength = 0;
            for(int iVerticalRow = 0; iVerticalRow < squares.length; ++iVerticalRow)
            {
                if(squares[iVerticalRow][iHorizontalRow] == 'b')
                    ++shipLength;
                else if (shipLength > 0 && squares[iVerticalRow][iHorizontalRow] != 'b')
                    shipLength = 0;
                if(shipLength == length && iVerticalRow + 1 < squares.length && squares[iVerticalRow + 1][iHorizontalRow] != 'b')
                    return true;
            }
        }
        return false;
    }
}
