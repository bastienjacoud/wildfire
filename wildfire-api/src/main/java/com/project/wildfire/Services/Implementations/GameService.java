package com.project.wildfire.Services.Implementations;

import com.project.wildfire.Helpers.CellHelper;
import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.Cinder;
import com.project.wildfire.Models.DTO.GameDTO;
import com.project.wildfire.Models.Grid;
import com.project.wildfire.Models.Fire;
import com.project.wildfire.Models.Position;
import com.project.wildfire.Models.Tree;
import com.project.wildfire.Services.IGameService;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for game
 */
@Service
public class GameService implements IGameService {

    /**
     * Return next game occurrence, after running one step of the simulation
     * @param currentGame Current game iteration
     * @return Next game iteration
     * @throws Exception
     */
    @Override
    public GameDTO goNextStep(GameDTO currentGame) throws Exception {
        currentGame.setGrid(new Grid(runStep(currentGame.getGrid().getCellList(), currentGame.getProbability())));
        currentGame.setStep(currentGame.getStep() + 1);
        return currentGame;
    }

    /**
     * Check if the simulation is finished or not.
     * @param currentGame Current game iteration
     * @return Boolean that specify if the simulation is ended or not.
     * @throws Exception
     */
    @Override
    public boolean checkEndGame(GameDTO currentGame) throws Exception {
        /* Vérifie qu'il y ait toujours des cellules en feu */
        return currentGame.getGrid().getCellList().stream()
                .noneMatch(cell -> cell instanceof Fire);
    }

    /**
     * Private method used to run one step
     * @param cellList List of cells of the current iteration
     * @param probability Probability of the game
     * @return List of cells of the next iteration
     */
    private List<AbstractCell> runStep(List<AbstractCell> cellList, double probability){
        /* Copie de la liste existante */
        var res = new ArrayList<>(cellList);
        /* Pour chaque cellule en feu */
        cellList.stream()
                .filter((cell -> cell instanceof Fire))
                .forEach(cell->{
                    /* On récupère les cellules adjacentes */
                    var adjacentCells = CellHelper.getAdjacentCells(cellList, cell);
                    adjacentCells.forEach(adjCell->{
                        /* Si la cellule est un arbre et que la probabilité le permet */
                        if(adjCell instanceof Tree){
                            if(Math.random()<probability){
                                /* On remplace la cellule adjacente par une cellule en feu */
                                Position adjCellPos = adjCell.getPos();
                                res.replaceAll(cell1-> cell1.getPos() == adjCellPos ? new Fire(adjCellPos) : cell1);
                            }
                        }
                    });
                    /* On remplace la cellule en feu par une cellule en cendres */
                    res.replaceAll(cell1-> cell1.getPos() == cell.getPos() ? new Cinder(cell.getPos()) : cell1);
                });
        return res;
    }
}
