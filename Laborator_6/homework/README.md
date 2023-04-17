1. Create the object oriented model of the game. Consider implementing a retained mode for drawing the game board.

    Am creat clasele:
    - ConfigurationPannel -> gestioneaza optiunile din header
    - ControlPanel -> gestioneaza optiunile din footer
    - Dot -> descrie un punct in spatiu
    - DrawingArea -> descrie aria de desen
    - GameLine -> descrie o linie
    - GameLogic -> contine metoda care calculeaza castigatorul

2. Implement the logic of the game. Use a mouse listener in order to select the line which must be colored, either by selecting the dots or the line itself. Validate the moves, according to the game rules. Determine the winner of the game.

    Fiecarei linii ii este atasata un eveniment si, in momentul in care este apasata, se schimba culoarea ei in functie de randul jucatorului, memorat in variabila player.

3. Export the current image of the game board into a PNG file.

    Am creat un nou buton "Export as PNG" care imi salveaza drawingArea in canva.png.

4. Use object serialization in order to save and restore the current status of the game.