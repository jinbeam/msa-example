import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';
import StarRateIcon from '@mui/icons-material/StarRate';
import SendIcon from '@mui/icons-material/Send';
import DraftsIcon from '@mui/icons-material/Drafts';
import DeleteIcon from '@mui/icons-material/Delete';
import ReportGmailerrorredIcon from '@mui/icons-material/ReportGmailerrorred';
import Divider from '@mui/material/Divider';

export const upMenu = [
  {
    key: 1,
    icon: <InboxIcon />,
    name: 'Inbox',
  },
  {
    key: 2,
    icon: <StarRateIcon />,
    name: 'Starred',
  },
  {
    key: 3,
    icon: <SendIcon />,
    name: 'Send email',
  },
  {
    key: 4,
    icon: <DraftsIcon />,
    name: 'Drafts',
  },
];

export const downMenu = [
  {
    key: 6,
    icon: <MailIcon />,
    name: 'All mail',
  },
  {
    key: 7,
    icon: <DeleteIcon />,
    name: 'Trash',
  },
  {
    key: 8,
    icon: <ReportGmailerrorredIcon />,
    name: 'Spam',
  },
];
