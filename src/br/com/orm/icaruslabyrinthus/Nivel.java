package br.com.orm.icaruslabyrinthus;

/**
 *
 * @author orm
 */
public class Nivel {
    //18 POR 18
    public static char[][][] fases = {
        {//NIVEL 0
    //COLUNA{'1','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18'},
            {' ', '0', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', '0', '0', '2' },//LINHA 01
            {'0', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ' },//LINHA 02
            {' ', ' ', '0', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ' },//LINHA 03
            {'0', '0', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', '0', ' ', ' ', '0', ' ', '0', ' ', ' ' },//LINHA 04
            {' ', '0', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', '0' },//LINHA 05
            {' ', ' ', ' ', ' ', '0', '0', ' ', ' ', ' ', ' ', '0', ' ', '0', '0', ' ', ' ', ' ', '0' },//LINHA 06
            {' ', '0', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', ' ', ' ', '0', '0', ' ', ' ' },//LINHA 07
            {' ', '0', '0', ' ', '0', ' ', ' ', '0', '0', ' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ' },//LINHA 08
            //{' ', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },//LINHA 09 HACK
            {' ', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0' },//LINHA 09
            {'0', '0', '0', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', '0', '0', ' ' },//LINHA 10
            {' ', ' ', ' ', ' ', '0', '0', ' ', '0', ' ', '1', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ' },//LINHA 11
            {' ', '0', '0', ' ', '0', ' ', ' ', '0', '0', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', '0' },//LINHA 12
            {' ', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', ' ' },//LINHA 13
            {'0', ' ', '0', ' ', ' ', ' ', '0', '0', ' ', ' ', ' ', '0', '0', '0', ' ', ' ', '0', ' ' },//LINHA 14
            {' ', '0', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ' },//LINHA 15
            {' ', ' ', ' ', '0', ' ', '0', ' ', '0', '0', '0', ' ', '0', ' ', '0', ' ', '0', ' ', '0' },//LINHA 16
            {'0', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', '0', ' ', ' ', ' ', '0', ' ', '0' },//LINHA 17
            {'0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ' }// LINHA 18
        },
        {//NIVEL 1
    //COLUNA{'1','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18'},
            {'0', '0', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ' },//LINHA 01
            {' ', ' ', ' ', '0', ' ', ' ', '0', ' ', '0', ' ', '0', '0', ' ', '0', '0', ' ', ' ', '0' },//LINHA 02
            {' ', '0', ' ', ' ', ' ', '0', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', '0', ' ', ' ' },//LINHA 03
            {' ', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', '0', ' ' },//LINHA 04
            {'0', ' ', ' ', '0', ' ', ' ', '0', '0', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', ' ' },//LINHA 05
            {' ', ' ', '0', ' ', ' ', '0', ' ', '0', '0', '0', ' ', ' ', '0', '0', '0', ' ', '0', ' ' },//LINHA 06
            {' ', '0', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0' },//LINHA 07
            {' ', ' ', '0', ' ', '0', ' ', '0', '0', ' ', '0', '0', ' ', ' ', '0', ' ', '0', ' ', ' ' },//LINHA 08
            {'0', ' ', '0', '0', ' ', '0', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', '0' },//LINHA 09
            {' ', ' ', '0', ' ', ' ', ' ', ' ', '1', '0', '0', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ' },//LINHA 10
            {' ', '0', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ' },//LINHA 11
            {' ', '0', '0', ' ', '0', '0', ' ', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ' },//LINHA 12
            {' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', ' ' },//LINHA 13
            {'0', ' ', '0', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ' },//LINHA 14
            {' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', '0', '0', ' ', ' ', ' ', ' ', '0', ' ' },//LINHA 15
            {' ', '0', '0', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', '0', ' ', '0', '0', ' ', ' ', '0' },//LINHA 16
            {' ', ' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ', '0' },//LINHA 17
            {' ', '0', '0', ' ', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', '0', ' ', ' ', ' ', '2' }// LINHA 18
        },
        {//NIVEL 2
    //COLUNA{'1','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18'},
            {' ', ' ', ' ', ' ', '0', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0' },//LINHA 01
            {'0', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', '0' },//LINHA 02
            {'0', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', '0', '0', ' ', '0', ' ', '0', ' ', ' ', ' ' },//LINHA 03
            {' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', '0', ' ' },//LINHA 04
            {' ', '0', ' ', ' ', '0', '0', '0', ' ', ' ', ' ', '0', '0', ' ', ' ', ' ', '0', ' ', '0' },//LINHA 05
            {' ', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ' },//LINHA 06
            {'0', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', '0', '0', ' ', ' ', '0', ' ', '0', '0', ' ' },//LINHA 07
            {' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', '1', ' ', '0', ' ', '0', '0', ' ', ' ', ' ', ' ' },//LINHA 08
            {' ', '0', '0', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', '0', '0', '0' },//LINHA 09
            {'0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', ' ' },//LINHA 10
            {' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', '0', ' ', ' ', '0', ' ', '0', '0', ' ' },//LINHA 11
            {' ', ' ', '0', '0', ' ', ' ', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', '0', ' ' },//LINHA 12
            {'0', ' ', ' ', ' ', '0', '0', ' ', '0', ' ', ' ', ' ', ' ', '0', '0', ' ', ' ', ' ', ' ' },//LINHA 13
            {'0', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', ' ' },//LINHA 14
            {' ', ' ', '0', ' ', '0', ' ', ' ', '0', ' ', '0', ' ', ' ', '0', ' ', ' ', '0', '0', '0' },//LINHA 15
            {' ', '0', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', '0', ' ', ' ' },//LINHA 16
            {' ', ' ', ' ', '0', ' ', '0', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', '0' },//LINHA 17
            {'2', '0', '0', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ' }// LINHA 18
        },
        {//NIVEL 3
    //COLUNA{'1','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18'},
            {'2', ' ', ' ', ' ', '0', '0', ' ', ' ', '0', ' ', ' ', '0', ' ', ' ', ' ', '0', '0', ' '},//LINHA 1
            {'0', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' ', ' '},//LINHA 2
            {'0', ' ', ' ', '0', '0', ' ', '0', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', '0', ' '},//LINHA 3
            {' ', '0', ' ', ' ', ' ', ' ', '0', '0', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', ' ', ' '},//LINHA 4
            {' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', '0', ' ', '0', ' ', '0', ' ', '0', ' ', '0'},//LINHA 5
            {' ', '0', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' '},//LINHA 6
            {' ', ' ', '0', ' ', '0', ' ', ' ', ' ', ' ', '0', ' ', ' ', '0', '0', ' ', '0', '0', ' '},//LINHA 7
            {' ', ' ', ' ', '0', ' ', '0', ' ', ' ', ' ', '1', ' ', '0', ' ', ' ', ' ', ' ', '0', ' '},//LINHA 8
            {' ', '0', ' ', ' ', ' ', ' ', '0', ' ', '0', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},//LINHA 9
            {'0', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', '0', ' ', '0', '0', ' ', '0'},//LINHA 10
            {' ', ' ', '0', ' ', '0', ' ', ' ', '0', '0', ' ', '0', '0', ' ', '0', ' ', '0', ' ', ' '},//LINHA 11
            {'0', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', '0', ' '},//LINHA 12
            {' ', '0', ' ', '0', '0', '0', ' ', ' ', '0', '0', '0', ' ', '0', ' ', ' ', '0', ' ', ' '},//LINHA 13
            {' ', ' ', ' ', ' ', ' ', '0', ' ', '0', ' ', ' ', '0', '0', ' ', ' ', '0', ' ', ' ', '0'},//LINHA 14
            {' ', '0', '0', ' ', ' ', ' ', '0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' '},//LINHA 15
            {' ', ' ', ' ', '0', '0', ' ', ' ', '0', ' ', '0', ' ', '0', '0', '0', ' ', ' ', '0', ' '},//LINHA 16
            {'0', ' ', ' ', '0', '0', ' ', '0', '0', ' ', '0', ' ', '0', ' ', ' ', '0', ' ', ' ', ' '},//LINHA 17
            {' ', '0', ' ', '0', ' ', ' ', ' ', ' ', ' ', '0', ' ', ' ', ' ', '0', ' ', ' ', '0', '0'}//LINHA 18
        }
    };
}
