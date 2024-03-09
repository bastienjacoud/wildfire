package com.project.wildfire.Services.Implementations;

import com.project.wildfire.Helpers.CellHelper;
import com.project.wildfire.Helpers.PositionHelper;
import com.project.wildfire.Models.Abstract.AbstractCell;
import com.project.wildfire.Models.DTO.GridDTO;
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
    public GridDTO goNextStep(GridDTO currentGrid) throws Exception {
        return new GridDTO(runStep(currentGrid.getCellList()), currentGrid.getStep() + 1);
    }

    private List<AbstractCell> runStep(List<AbstractCell> cellList){
        /* Copie de la liste existante */
        var res = new ArrayList<>(cellList);
        /* Pour chaque cellule en feu */
        cellList.stream()
                .filter((cell -> cell instanceof Fire))
                .forEach(cell->{
                    /* On récupère les cellules adjacentes */
                    var adjacentCells = CellHelper.getAdjacentCells(cellList, cell);
                    adjacentCells.forEach(adjCell->{
                        /* On remplace la cellule par une cellule en feu, en fonction de la probabilité définie */
                        if(adjCell instanceof Tree){
                            if(Math.random()<0.5){
                                Position adjCellPos = adjCell.getPos();
                                res.replaceAll(cell1-> PositionHelper.samePosition(cell1.getPos(), adjCellPos) ? new Fire(adjCellPos) : cell1);
                            }
                        }
                    });
                });
        return res;
    }
}
