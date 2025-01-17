import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles({
  root: {
    margin: 20,
    borderWidth: 0,
    borderStyle: 'solid',
  },
  title: {
    fontSize: 24,
  },
});

export default function AccountBanner() {
  const classes = useStyles();

  return (
    <Card className={classes.root}>
      <CardContent>
        <Typography className={classes.title}>
          Account Name - Transactions
        </Typography>
      </CardContent>
    </Card>
  );
}