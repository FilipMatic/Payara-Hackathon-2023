import React, { useState } from 'react';

import { makeStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import ListItemSecondaryAction from '@material-ui/core/ListItemSecondaryAction';
import ListItemText from '@material-ui/core/ListItemText';
import Avatar from '@material-ui/core/Avatar';
import FolderIcon from '@material-ui/icons/Folder';
import Dialog from '@material-ui/core/Dialog';

import AccountBanner from '../components/AccountBanner';
import AccountInsight from '../components/AccountInsight';

import axios from 'axios';

const useStyles = makeStyles((theme) => ({
  root: {
    width: 'auto',
    display: 'inline-flex',
    backgroundColor: theme.palette.background.paper,
  },
  title: {
    margin: theme.spacing(4, 0, 2),
  },
  view: {
    padding: 20,
  },
  list: {
    minWidth: 400,
  }
}));

const generateBoards = (accounts, handleClickOpen) => {
  return accountsTEMP.map((value) => {
    return (
      <ListItem button onClick={handleClickOpen}>
        <ListItemAvatar>
          <Avatar>
            <FolderIcon />
          </Avatar>
        </ListItemAvatar>
        <ListItemText
          primary={value.accountId}
        />
        <ListItemSecondaryAction>
          <ListItemText
            primary={value.balance}
          />
        </ListItemSecondaryAction>
      </ListItem>
    )
  });
}

function createData(id, accountId, balance) {
  return { id, accountId, balance };
}

// Backend is not connected yet - mocked data
const accountsTEMP = [
  createData(1, 'Chequing', '$100'),
  createData(2, 'Savings', '$5000'),
  createData(3, 'Credit', '$700'),
];

// will need to perform a GET for the user's accounts on every load of the page
export default function AccountsList({ id }) {
  const classes = useStyles();

  const [accounts, setAccounts] = useState(List);
  // const [secondary, setSecondary] = React.useState(false);
  const [open, setOpen] = useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  // Get client accounts
  const getAccounts = (clientId) => {
    axios.get('http://localhost:8080/jee-jumpstart/api/accounts/' + clientId)
      .then((res) => {
        // check response code and response JSON
        setAccounts(res.data);
        if (res.status === 200) {
          generateBoards(accounts, handleClickOpen);
        }
      })
  };

  // Checking client existance 
  const checkId = (clientId) => {
    axios.get('http://localhost:8080/jee-jumpstart/api/client/' + clientId)
      .then((res) => {
        // if not 
        if (res.status === 200) {
          generateBoards(accounts, handleClickOpen);
          getAccounts(id);
        } else if (res.status === 400) {
          // create client
          // ask client to create account
        }
      })
  };

  return (
    <div className={classes.root}>
      <List className={classes.list}>
        { 
          generateBoards(accountsTEMP, handleClickOpen)
          // checkId(id) // should be calling this
        }
      </List>
      <Dialog
        open={open}
        onClose={handleClose}
        fullWidth
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >        
        <div className={classes.view}>
          <AccountBanner />
          <AccountInsight />
        </div>
      </Dialog>
    </div>
  );
}