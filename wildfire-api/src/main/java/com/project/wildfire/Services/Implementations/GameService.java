package com.project.wildfire.Services.Implementations;

import com.project.wildfire.Helpers.CellHelper;
import com.project.wildfire.Helpers.PositionHelper;
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

@Service
public class GameService implements IGameService {
    @Override
    public GameDTO goNextStep(GameDTO currentGame) throws Exception {
        currentGame.setGrid(new Grid(runStep(currentGame.getGrid().getCellList(), currentGame.getProbability())));
        currentGame.setStep(currentGame.getStep() + 1);
        return currentGame;
    }

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
                                res.replaceAll(cell1-> PositionHelper.samePosition(cell1.getPos(), adjCellPos) ? new Fire(adjCellPos) : cell1);
                            }
                        }
                    });
                    /* On remplace la cellule en feu par une cellule en cendres */
                    res.replaceAll(cell1-> PositionHelper.samePosition(cell1.getPos(), cell.getPos()) ? new Cinder(cell.getPos()) : cell1);
                });
        return res;
    }
}
