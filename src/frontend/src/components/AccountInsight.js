import React from 'react';

import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const StyledTableCell = withStyles((theme) => ({
  head: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 18,
  },
}))(TableCell);

const StyledTableRow = withStyles((theme) => ({
  root: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover,
    },
  },
}))(TableRow);

function createData(name, wins) {
  return { name, wins };
}

// Mocking data for now
const transactions = [
  createData('Whole Foods', 600),
  createData('Foot Locker', 150),
  createData('Transfer', 16),
];

export default function AccountInsight() {
  return (
    <TableContainer component={Paper}>
      <Table aria-label="customized table">
        <TableBody>
          {transactions.map((row) => (
            <StyledTableRow key={row.name}>
              <StyledTableCell component="th" scope="row" width="33.3%">
                {row.name}
              </StyledTableCell>
              <StyledTableCell align="right">{row.wins}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}